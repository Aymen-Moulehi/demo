package com.esprit.demo.rendezvous;

import com.esprit.demo.medecin.Medecin;
import com.esprit.demo.patient.Patient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/rendezVous")
public class RendezVousRestController {
    IRendezVousService rendezVousService;

    @PostMapping("/add-rendezVous")
    public RendezVous addRendezVousS(@RequestBody RendezVous rendezVous) {
        return rendezVousService.addRendezVous(rendezVous);
    }


    @PostMapping("/add-RDV-and-assign-med-and-patient")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @RequestParam Integer idMedecin, @RequestParam Integer idPatient) {
        rendezVousService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }
}
