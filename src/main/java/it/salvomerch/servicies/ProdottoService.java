package it.salvomerch.servicies;

import it.salvomerch.entities.Categoria;
import it.salvomerch.entities.Prodotto;
import it.salvomerch.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private EntityManager em;

    @Transactional(readOnly = true)
    public Prodotto getProdotto(int id){
        return prodottoRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Prodotto> showAllProducts(){

        return prodottoRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void addProduct(Prodotto prodotto){
        if(prodottoRepository.existsById(prodotto.getId()))
            throw new IllegalArgumentException(("Prodotto già esistente!"));
        prodottoRepository.save(prodotto);
    }

    @Transactional(readOnly = false)
    public void updateProduct(Prodotto prodotto){
        if(!prodottoRepository.existsById(prodotto.getId()))
            throw  new IllegalArgumentException("prodotto inesistente!");
        Prodotto old=em.find(Prodotto.class, prodotto.getId());
        Integer prezzo=prodotto.getPrezzo(); Integer quantita=prodotto.getQuantita();
        String nome=prodotto.getNome();
        Categoria categoria=prodotto.getCategoria();
        if(prezzo!=null) old.setPrezzo(prezzo);
        if(quantita!=null) old.setQuantita(quantita);
        if(nome!=null) old.setNome(nome);
        em.flush();
    }

    @Transactional(readOnly = true)
    public int getQuantita(int id){
        Prodotto p= prodottoRepository.findById(id);
        if(p==null)return 0;
        return p.getQuantita();
    }
}
