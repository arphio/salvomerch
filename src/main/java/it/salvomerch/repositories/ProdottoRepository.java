package it.salvomerch.repositories;

import it.salvomerch.entities.Categoria;
import it.salvomerch.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

    Prodotto findById(int id);
    List<Prodotto> findByNome(String nome);
    List<Prodotto> findByPrezzoGreaterThan(int prezzo);
    List<Prodotto> findByPrezzoLessThan(int prezzo);

    boolean existsById(int id);
    List<Prodotto> findByCategoria(Categoria c);
}
