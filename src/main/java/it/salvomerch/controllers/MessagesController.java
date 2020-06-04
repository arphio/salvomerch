package it.salvomerch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MessagesController {

    @GetMapping("/api/messages")
    public List<String> getMessages(Principal principal) {
        //TODO
    }


}
