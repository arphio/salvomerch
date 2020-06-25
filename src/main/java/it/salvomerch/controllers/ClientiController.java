package it.salvomerch.controllers;

import it.salvomerch.entities.Cliente;
import it.salvomerch.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")

public class ClientiController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<Cliente> allCliente(){ return clienteService.showAllCliente();}


    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente c){
        System.out.println(c);
        clienteService.addCliente(c);
    }
}
