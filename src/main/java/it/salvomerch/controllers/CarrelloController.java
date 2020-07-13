package it.salvomerch.controllers;


import it.salvomerch.entities.Cliente;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.servicies.CarrelloService;
import it.salvomerch.servicies.ClienteService;
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

    @GetMapping
    public List<ProdottoInCarrello> getProdottiInCarr(@AuthenticationPrincipal Principal user){
        Cliente c= clienteService.getCliente(user);
        return carrelloService.getProdottiCarrello(c.getEmail());
    }

    @PostMapping("/remove")
    public ResponseEntity rimuoviProdotto(@AuthenticationPrincipal Principal user, @RequestBody ProdottoInCarrello prodottoInCarrello){
        carrelloService.rimuoviProdottoInCarrello(user, prodottoInCarrello);
        return new ResponseEntity(prodottoInCarrello, HttpStatus.OK);
    }
}
