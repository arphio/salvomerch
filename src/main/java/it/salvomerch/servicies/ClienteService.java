package it.salvomerch.servicies;


import it.salvomerch.entities.Cliente;
import it.salvomerch.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Cliente> showAllCliente(){

        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente getById(int id){
        return  clienteRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public void deleteClientebyId(int id){
        clienteRepository.deleteById(id);
        clienteRepository.flush();
    }

    @Transactional(readOnly = false)
    public void addCliente(Cliente c){
        if(clienteRepository.existsById(c.getId()) || clienteRepository.findByEmail(c.getEmail())!=null)
            throw new IllegalArgumentException("cliente gia esistente!");
        clienteRepository.save(c);
    }
}
