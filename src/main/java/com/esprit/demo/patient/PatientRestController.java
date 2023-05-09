package com.esprit.demo.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientRestController {
    IPatientService patientService;

    @PostMapping("/add-patient")
    public Patient addPatientS(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
}
