package it.salvomerch.repositories;

import it.salvomerch.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findById(int id);
    Cliente findByEmail(String email);

}
