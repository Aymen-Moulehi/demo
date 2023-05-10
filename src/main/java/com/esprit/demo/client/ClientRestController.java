package com.esprit.demo.client;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {
    IClientService clientService;

    @PostMapping("/add-client")
    public Client addClientS(@RequestBody Client client) {
        return clientService.addClient(client);
    }


    @PutMapping("/affecter-Client-AuMenu")
    public void affecterClientAuMenu(String identifiant, String libelleMenu) {
        clientService.affecterClientAuMenu(identifiant, libelleMenu);
    }
}
