package it.salvomerch.servicies;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.Ordine;
import it.salvomerch.entities.Prodotto;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.repositories.ClienteRepository;
import it.salvomerch.repositories.OrdineRepository;
import it.salvomerch.repositories.ProdottoInCarrelloRepository;
import it.salvomerch.support.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.TransactionScoped;
import java.nio.file.ProviderNotFoundException;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class CarrelloService {

    @Autowired
    private ProdottoInCarrelloRepository prodottoInCarrelloRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private OrdineRepository ordineRepository;

    @Transactional(readOnly = false)
    public ProdottoInCarrello aggiungiProdotto(Principal user, ProdottoInCarrello prodotto){
        System.out.println("user is "+user.getName());
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Cliente c= clienteService.getCliente(user);
        System.out.println("cliente is "+c.getId()+ c.getNome()+ c.getEmail()+ c.getCarrello());
        prodotto.setCliente(c);
        System.out.println("Il prodotto da aggiungere è :" +prodotto.getProdotto());
        for( ProdottoInCarrello p : c.getCarrello()){
            System.out.println("il prodotto è : "+p.getProdotto().getNome());
            if(p.equals(prodotto)){
                System.out.println("I prodotti sono uguali");
                p.setQuantita(p.getQuantita()+prodotto.getQuantita());
                return p;
            }
        }
        prodotto= prodottoInCarrelloRepository.save(prodotto);
        return prodotto;
    }

    @Transactional
    public List<ProdottoInCarrello> updateCarrello(Principal user, List<ProdottoInCarrello> prodotti){
        Cliente c= clienteService.getCliente(user);
        c.getCarrello().clear();
        for(ProdottoInCarrello p : prodotti){
            p.setCliente(c);
            p= prodottoInCarrelloRepository.save(p);
            c.getCarrello().add(p);
        }
        return (List<ProdottoInCarrello>) c.getCarrello();
    }


    @Transactional(readOnly = false)
    public Ordine registraOrdine(Principal user, Ordine ordine){
        Cliente c= clienteService.getCliente(user);
        if(c.getCarrello().isEmpty())throw new IllegalStateException();
        Ordine newOrdine = new Ordine();
        newOrdine.setCliente(c);
        newOrdine.setDataacquisto(Timestamp.from(Instant.now()));
        newOrdine.setId(0);
        newOrdine.setTotale(0.0);
        newOrdine= ordineRepository.save(newOrdine);
        entityManager.flush();
        entityManager.lock(Prodotto.class, LockModeType.OPTIMISTIC);
        entityManager.lock(Carrello.class, LockModeType.OPTIMISTIC);
        for(ProdottoInCarrello p : prodottoInCarrelloRepository.findByCliente(c)){
            Prodotto prod= entityManager.find(Prodotto.class, p.getProdotto().getId());
            newOrdine.addProdotto(prod, p.getQuantita());
            prod.setQuantita(prod.getQuantita()-p.getQuantita());
        }
        c.getCarrello().clear();
        entityManager.lock(Prodotto.class, LockModeType.NONE);
        entityManager.lock(Carrello.class, LockModeType.NONE);
        entityManager.flush();
        return newOrdine;
    }


    @Transactional(readOnly = true)
    public List<ProdottoInCarrello> getProdottiCarrello(String email){
        return prodottoInCarrelloRepository.findByCliente_Email(email);
    }

}
