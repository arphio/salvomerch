package it.salvomerch.repositories;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.ProdottoInCarrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findById(int id);
    Cliente findByEmail(String email);
    void deleteById(int id);
    boolean existsById(int id);
    boolean existsByEmail(String email);

}
