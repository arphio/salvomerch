package it.salvomerch.servicies;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.repositories.ProdottoInCarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CarrelloService {

    @Autowired
    private ProdottoInCarrelloRepository prodottoInCarrelloRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<ProdottoInCarrello> getProdottiCarrello(String email){
        return prodottoInCarrelloRepository.findByCliente_Email(email);
    }
}
