package com.esprit.demo.medecin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/medecin")
public class MedecinRestController {
    IMedecinService medecinService;

    @PostMapping("/add-medecin")
    public Medecin addMedecinS(@RequestBody Medecin medecin) {
        return medecinService.addMedecin(medecin);
    }
}
