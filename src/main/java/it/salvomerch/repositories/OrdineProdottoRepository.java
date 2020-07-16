package it.salvomerch.repositories;


import it.salvomerch.entities.Ordine;
import it.salvomerch.entities.OrdineProdotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineProdottoRepository extends JpaRepository<OrdineProdotto, Integer> {

    List<OrdineProdotto> findByOrdine(Ordine ordine);

}
