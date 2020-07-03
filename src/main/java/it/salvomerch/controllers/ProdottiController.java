package it.salvomerch.controllers;

import it.salvomerch.entities.Prodotto;
import it.salvomerch.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4300"})

public class ProdottiController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public List<Prodotto> allProducts(){
        return prodottoService.showAllProducts();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        this.prodottoService.deleteProduct(id);
    }

    @PostMapping("/update")
    public void  updateProduct(@RequestBody Prodotto prodotto){
        prodottoService.updateProduct(prodotto);
    }

    @PostMapping("/add")
    public void addProdotto(@RequestBody Prodotto prodotto){
        prodottoService.addProduct(prodotto);
    }

    @GetMapping(path = "/{id}")
    public Prodotto getProdotto(@PathVariable("id") int id){
        return prodottoService.getProdotto(id);
    }
}
