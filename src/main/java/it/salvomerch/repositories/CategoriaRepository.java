package it.salvomerch.repositories;

import it.salvomerch.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

    Categoria findByNome(String nome);
}
