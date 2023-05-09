package com.esprit.demo.clinique;

import com.esprit.demo.medecin.Medecin;
import com.esprit.demo.medecin.MedecinRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class CliniqueServiceImpl implements ICliniqueService {

    CliniqueRepository cliniqueRepository;
    MedecinRepository medecinRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Integer cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).get();
        medecin.getCliniques().add(clinique);
        return medecinRepository.save(medecin);
    }
}