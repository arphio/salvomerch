package it.salvomerch.controllers;

import it.salvomerch.entities.Prodotto;
import it.salvomerch.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@CrossOrigin("http://localhost:4300")
public class ShopController {
    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public List<Prodotto> getProdotti(){
        return prodottoService.showAllProducts();
    }

}
