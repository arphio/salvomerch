package it.salvomerch.repositories;


import it.salvomerch.entities.OrdineProdotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineProdottoRepository extends JpaRepository<OrdineProdotto, Integer> {


}
