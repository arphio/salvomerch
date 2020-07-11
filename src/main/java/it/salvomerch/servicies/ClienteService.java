package it.salvomerch.servicies;


import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.repositories.ClienteRepository;
import it.salvomerch.support.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Carrello getCarrello(Principal user){
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

    public static String getUserEmail(Principal user){
        String email=user.getName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getPrincipal() instanceof OidcUser) email= ((OidcUser) auth.getPrincipal()).getEmail();
        System.out.println("email is"+ email);
        return  email;
    }

    @Transactional(readOnly = false)
    public Cliente getCliente(Principal user){
        String email= getUserEmail(user);
        if(clienteRepository.existsByEmail(email))
            return getCliente(email);
        return accounting(user);
    }

    @Transactional(readOnly = true)
    public Cliente getCliente(String email){
        return clienteRepository.findByEmail(email);
    }

    @Transactional
    public Cliente accounting(Principal user){
        String email=user.getName();
        Cliente c=new Cliente();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth.getPrincipal() instanceof OidcUser){
            email=((OidcUser) auth.getPrincipal()).getEmail();
            c.setNome(((OidcUser) auth.getPrincipal()).getFullName());
        }
        c.setCarrello(new LinkedList<>());
        c.setOrdini(new LinkedList<>());
        c.setEmail(email);
        clienteRepository.saveAndFlush(c);
        System.out.println(c);
        return c;
    }
}
