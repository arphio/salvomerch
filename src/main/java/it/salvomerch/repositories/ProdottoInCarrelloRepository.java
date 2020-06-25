package it.salvomerch.repositories;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.Prodotto;
import it.salvomerch.entities.ProdottoInCarrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoInCarrelloRepository extends JpaRepository<ProdottoInCarrello, Integer> {

    List<ProdottoInCarrello> findByCliente(Cliente c);
    ProdottoInCarrello findById(int id);
}
