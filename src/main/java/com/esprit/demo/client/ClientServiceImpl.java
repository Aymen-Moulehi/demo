package com.esprit.demo.client;

import com.esprit.demo.menu.Menu;
import com.esprit.demo.menu.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ClientServiceImpl implements IClientService {

    ClientRepository clientRepository;
    MenuRepository menuRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void affecterClientAuMenu(String identifiant, String libelleMenu) {
        Client client = clientRepository.findFirstByIdentifiant(identifiant);
        Menu menu = menuRepository.findFirstByLibelleMenu(libelleMenu);
        if(menu != null){
            if(menu.getClients() == null)
                menu.setClients(new ArrayList<Client>());
            menu.getClients().add(client);
            menuRepository.save(menu);

        }
    }
}