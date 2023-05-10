package com.esprit.demo.composant;

import com.esprit.demo.menu.Menu;
import com.esprit.demo.menu.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ComposantServiceImpl implements IComposantService {

    ComposantRepository composantRepository;
    MenuRepository menuRepository;

    @Override
    public Composant addComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Menu ajoutComposantsEtMiseAjourPrixTotalMenu(List<Composant> composants, Integer idMenu) {

        float total = (float) composants.stream().mapToDouble(value -> value.getPrix()).sum();
        Menu menu;
        if(total < 20){
            menu = menuRepository.findById(idMenu).get();
            if(menu.getComposants() == null)
                menu.setComposants(new ArrayList<Composant>());
            composants.forEach(composant -> menu.getComposants().add(
                    composantRepository.save(composant)
            ));
            menuRepository.save(menu);
        }
        return null;
    }
}