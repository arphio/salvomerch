package it.salvomerch.controllers;


import it.salvomerch.entities.Prodotto;
import it.salvomerch.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String saluto(){
        return "ciao";
    }

    @GetMapping("/products")
    public List<Prodotto> allProducts(){
        return prodottoService.showAllProducts();
    }
}
