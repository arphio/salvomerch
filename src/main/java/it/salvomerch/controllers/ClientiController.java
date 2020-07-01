package it.salvomerch.controllers;

import it.salvomerch.entities.Cliente;
import it.salvomerch.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")

public class ClientiController {

    private byte[] bytes;

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<Cliente> allCliente(){ return clienteService.showAllCliente();}


    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente c){
        System.out.println(c);
        clienteService.addCliente(c);
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile")MultipartFile file) throws IOException {
        this.bytes=file.getBytes();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCliente(@PathVariable("id") int id){
        clienteService.deleteClientebyId(id);
    }
}
