package com.esprit.demo.menu;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class MenuServiceImpl implements IMenuService {

    MenuRepository menuRepository;

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<String> libelleMenuParTypeMenuOrdonneParPrixTotal(TypeMenu typeMenu) {

        List<String> strings = new ArrayList<>();
        menuRepository.findAllByTypeMenu(typeMenu)
                .stream().sorted((o1, o2) -> o1.getPrixTotal().compareTo(o2.getPrixTotal()))
                .forEach(menu -> strings.add(menu.getLibelleMenu()));
        return strings;
    }


    @Scheduled(fixedDelay = 30000)
    void menuPlusCommande(){
        Menu menu = menuRepository.findAll().stream().sorted((o1, o2) -> o1.getClients().size() - o2.getClients().size()).findFirst().get();
        log.info("Le menu le plus commandé dans votre restuaurant est " + menu.getLibelleMenu());
    }
}