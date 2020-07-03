package it.salvomerch.controllers;


import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.servicies.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chart")
@CrossOrigin("http://localhost:4300")
public class CarrelloController {

    @Autowired
    private CarrelloService carrelloService;

    @GetMapping
    public List<ProdottoInCarrello> getProdottiInCarr(@AuthenticationPrincipal OidcUser user){
        return carrelloService.getProdottiCarrello(user.getEmail());
    }
}
