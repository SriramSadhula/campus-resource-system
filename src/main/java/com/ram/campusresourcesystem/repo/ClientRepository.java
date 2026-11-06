package com.ram.campusresourcesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ram.campusresourcesystem.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
    
    
}
