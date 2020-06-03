package it.salvomerch.controllers;


import it.salvomerch.entities.Prodotto;
import it.salvomerch.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
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

    @PostMapping("/products")
    public void addProdotto(@RequestBody Prodotto prodotto){
        prodottoService.addProduct(prodotto);
    }
}
