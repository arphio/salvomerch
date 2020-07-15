package it.salvomerch.controllers;


import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.Ordine;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.servicies.CarrelloService;
import it.salvomerch.servicies.ClienteService;
import it.salvomerch.support.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4300")
public class CarrelloController {

    @Autowired
    private CarrelloService carrelloService;
    @Autowired
    private ClienteService clienteService;


    @PostMapping("/orderreg")
    public ResponseEntity regOridne(@AuthenticationPrincipal Principal user, @RequestBody Ordine ordine) {
        Ordine o = carrelloService.registraOrdine(user, ordine);
        return new ResponseEntity(o, HttpStatus.OK);
    }

    @GetMapping
    public Carrello getProdottiInCarr(@AuthenticationPrincipal Principal user) {
        Cliente c = clienteService.getCliente(user);
        Carrello carr= new Carrello(carrelloService.getProdottiCarrello(c.getEmail()));
        return carr;
    }

    @GetMapping("/empty")
    public ResponseEntity emptyCarrello(@AuthenticationPrincipal Principal user){
        carrelloService.emptyCart(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity rimuoviProdotto(@AuthenticationPrincipal Principal user, @RequestBody ProdottoInCarrello prodottoInCarrello){
        carrelloService.rimuoviProdottoInCarrello(user, prodottoInCarrello);
        return new ResponseEntity(prodottoInCarrello, HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public Cliente getCliente(@AuthenticationPrincipal Principal user){
        return clienteService.getCliente(user);
    }

    @GetMapping("/clientename")
    public String getClienteName(@AuthenticationPrincipal Principal user){
        Cliente c=clienteService.getCliente(user);
        return  c.getNome();
    }

    @GetMapping("/clienteemail")
    public String getClienteEmail(@AuthenticationPrincipal Principal user){
        Cliente c=clienteService.getCliente(user);
        System.out.println(c.getEmail());
        return  c.getNome();
    }
}
