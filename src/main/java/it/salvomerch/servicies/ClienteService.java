package it.salvomerch.servicies;


import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.repositories.ClienteRepository;
import it.salvomerch.support.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    public Carrello getCarrello(@AuthenticationPrincipal OidcUser user){
        Cliente c= getCliente(user);
        List<ProdottoInCarrello> prodotti = (List<ProdottoInCarrello>) c.getCarrello();
        return new Carrello(prodotti);
    }

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
        if(!clienteRepository.existsById(id)) return;
        clienteRepository.deleteById(id);
        System.out.println("deleted cliente "+id);
        clienteRepository.flush();
    }

    @Transactional(readOnly = false)
    public void addCliente(Cliente c){
        if(clienteRepository.existsByEmail(c.getEmail()))
            throw new IllegalArgumentException("cliente gia esistente!");
        clienteRepository.save(c);
    }

    public static String getUserEmail(OidcUser user){
        return user.getEmail();
    }

    @Transactional(readOnly = false)
    public Cliente getCliente(OidcUser user){
        String email= getUserEmail(user);
        if(!clienteRepository.existsByEmail(email))
            accounting(user);
        return getCliente(email);
    }

    @Transactional(readOnly = true)
    public Cliente getCliente(String email){
        return clienteRepository.findByEmail(email);
    }

    @Transactional(readOnly = false)
    public void accounting(@AuthenticationPrincipal OidcUser user){
        String email=user.getEmail();
        if(clienteRepository.existsByEmail(email)) return;
        Cliente c= new Cliente();
        c.setNome(user.getFullName());
        c.setEmail(user.getEmail());
        clienteRepository.save(c);
    }
}
