package com.esprit.demo.clinique;

import com.esprit.demo.medecin.Medecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/clinique")
public class CliniqueRestController {
    ICliniqueService cliniqueService;

    @PostMapping("/add-clinique")
    public Clinique addCliniqueS(@RequestBody Clinique clinique) {
        return cliniqueService.addClinique(clinique);
    }

    @PostMapping("/add-medecin-and-assign-to-clinique")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @RequestParam Integer cliniqueId) {
        return cliniqueService.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }
}
