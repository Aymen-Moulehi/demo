package com.esprit.demo.clinique;

import com.esprit.demo.medecin.Medecin;

public interface ICliniqueService {
    Clinique addClinique(Clinique clinique);

    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Integer cliniqueId);
}