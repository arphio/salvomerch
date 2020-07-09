package it.salvomerch.servicies;

import it.salvomerch.entities.Categoria;
import it.salvomerch.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<Categoria> showAllCategories(){
        return  categoriaRepository.findAll();
    }
}
