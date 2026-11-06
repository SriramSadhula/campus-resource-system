package com.ram.campusresourcesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.campusresourcesystem.entity.Client;
import com.ram.campusresourcesystem.repo.ClientRepository;

@Service 
public class ClientService {
    @Autowired 
    private  ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client c) {
        return clientRepository.save(c);
    }
}
