package com.ram.campusresourcesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.campusresourcesystem.entity.Client;
import com.ram.campusresourcesystem.service.ClientService;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hoppscotch.io"
})
public class ClientController {
    @Autowired 
    private  ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client addClient(@RequestBody Client entity) {
        return clientService.addClient(entity);
    }
}
