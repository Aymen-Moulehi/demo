package com.esprit.demo.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findFirstByIdentifiant(String identifiant);
}
