package it.salvomerch.servicies;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.Ordine;
import it.salvomerch.entities.OrdineProdotto;
import it.salvomerch.repositories.OrdineProdottoRepository;
import it.salvomerch.repositories.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.transaction.TransactionScoped;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrdiniService {

    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private OrdineProdottoRepository ordineProdottoRepository;

    @Transactional(readOnly = true)
    public List<Ordine> getOrdiniCliente(Principal user){
        Cliente c= clienteService.getCliente(user);
        return ordineRepository.findByCliente(c);
    }

    @Transactional(readOnly = true)
    public List<OrdineProdotto> getProdottiOrdinati(Principal user, Ordine ordine){
        Optional<Ordine> o= ordineRepository.findById(ordine.getId());
        if(!o.isPresent())throw new NoSuchElementException("Ordine non presente nel database!");
        return ordineProdottoRepository.findByOrdine(o.get());
    }

    @Transactional(readOnly = true)
    public String getData(Ordine ordine){
        entityManager.find(Ordine.class, ordine);
        String res=ordine.getDataacquisto().getDay()+" "+ordine.getDataacquisto().getMonth()+" "+
                ordine.getDataacquisto().getYear();
        System.out.println(res);
        return res;
    }

}
