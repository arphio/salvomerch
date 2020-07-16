package it.salvomerch.controllers;

import it.salvomerch.entities.Ordine;
import it.salvomerch.entities.OrdineProdotto;
import it.salvomerch.servicies.OrdiniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("http://localhost:4300")
public class OrdiniController {

    @Autowired
    private OrdiniService ordiniService;

    @GetMapping
    public List<Ordine> getOrdiniCliente(@AuthenticationPrincipal Principal user){
        return ordiniService.getOrdiniCliente(user);
    }

    @PostMapping("/ordered")
    public List<OrdineProdotto> getProdottiOrdinati(@AuthenticationPrincipal Principal user, @RequestBody Ordine ordine){
        List<OrdineProdotto> l=ordiniService.getProdottiOrdinati(user,ordine);
        for(OrdineProdotto op : l){
            System.out.println(op.getProdotto().getNome()+" "+op.getProdotto().getQuantita());
        }
        return l;
    }

    @PostMapping("/data")
    public String getData(@RequestBody Ordine ordine){
        return ordiniService.getData(ordine);
    }
}
