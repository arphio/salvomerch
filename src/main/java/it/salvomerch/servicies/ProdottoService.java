package it.salvomerch.servicies;

import it.salvomerch.entities.Prodotto;
import it.salvomerch.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private EntityManager em;


    @Transactional(readOnly = true)
    public List<Prodotto> showAllProducts(){

        return prodottoRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void addProduct(Prodotto prodotto){
        if(prodotto.getId()!= null && prodottoRepository.existsById(prodotto.getId()))
            throw new IllegalArgumentException("Prodotto già esistente! ");
        prodottoRepository.save(prodotto);
    }
}
