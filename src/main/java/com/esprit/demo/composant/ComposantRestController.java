package com.esprit.demo.composant;

import com.esprit.demo.menu.Menu;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/composant")
public class ComposantRestController {
    IComposantService composantService;

    @PostMapping("/add-composant")
    public Composant addComposantS(@RequestBody Composant composant) {
        return composantService.addComposant(composant);
    }

    @PutMapping("/ajout-Composants-Et-Mise-Ajour-Prix-Total-Menu")
    public Menu ajoutComposantsEtMiseAjourPrixTotalMenu(@RequestBody List<Composant> composants, @RequestParam Integer idMenu) {
        return composantService.ajoutComposantsEtMiseAjourPrixTotalMenu(composants, idMenu);
    }
}
