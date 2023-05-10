package com.esprit.demo.client;

public interface IClientService {
    Client addClient(Client client);
    void affecterClientAuMenu(String identifiant, String libelleMenu);
}