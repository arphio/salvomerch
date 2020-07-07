package it.salvomerch.controllers;

import it.salvomerch.entities.Cliente;
import it.salvomerch.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4300"})

public class ClientiController {

    private byte[] bytes;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @PreAuthorize("hasAuthority('admins')")
    public List<Cliente> allCliente(){ return clienteService.showAllCliente();}


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admins')")
    public void addCliente(@RequestBody Cliente c){
        System.out.println(c);
        clienteService.addCliente(c);
    }

 /*  @PostMapping("/reg")
    public void addClienteAuth(@AuthenticationPrincipal OidcUser user){
        clienteService.accounting(user);
    }*/

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile")MultipartFile file) throws IOException {
        this.bytes=file.getBytes();
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('admins')")
    public void deleteCliente(@PathVariable("id") int id){
        clienteService.deleteClientebyId(id);
    }
}
