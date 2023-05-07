package com.esprit.demo.contrat;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {
    IContratService contratService;

    @PostMapping("/add-contrat")
    public Contrat addContratS(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }
}
