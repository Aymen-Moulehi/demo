package com.esprit.demo.rendezvous;

import com.esprit.demo.medecin.Specialite;

import java.util.List;

public interface IRendezVousService {
    RendezVous addRendezVous(RendezVous rendezVous);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Integer idMedecin, Integer idPatient);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Integer idClinique, Specialite specialite);

    public void retrieveRendezVous();
}