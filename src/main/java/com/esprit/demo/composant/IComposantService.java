package com.esprit.demo.composant;

import com.esprit.demo.menu.Menu;

import java.util.List;

public interface IComposantService {
    Composant addComposant(Composant composant);
    Menu ajoutComposantsEtMiseAjourPrixTotalMenu(List<Composant> composants, Integer idMenu);
}