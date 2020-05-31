package it.salvomerch.repositories;

import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

    Ordine findById(int id);
    List<Ordine> findByCliente(Cliente c);
    List<Ordine> findByDataacquisto(Timestamp data);
    List<Ordine> findByClienteAndDataacquisto(Cliente c, Timestamp data);
}
