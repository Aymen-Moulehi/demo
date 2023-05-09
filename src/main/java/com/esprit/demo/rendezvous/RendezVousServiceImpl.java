package com.esprit.demo.rendezvous;

import com.esprit.demo.medecin.Medecin;
import com.esprit.demo.medecin.MedecinRepository;
import com.esprit.demo.medecin.Specialite;
import com.esprit.demo.patient.Patient;
import com.esprit.demo.patient.PatientRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.CalendarUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class RendezVousServiceImpl implements IRendezVousService {

    RendezVousRepository rendezVousRepository;
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;

    @Override
    public RendezVous addRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Integer idMedecin, Integer idPatient) {
        Medecin medecin = medecinRepository.findById(idMedecin).get();
        Patient patient = patientRepository.findById(idPatient).get();
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rendezVousRepository.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Integer idClinique, Specialite specialite) {
        return null;
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void retrieveRendezVous() {
        Calendar cal = Calendar.getInstance();
        Date date =cal.getTime();
       rendezVousRepository.findAll().stream().filter(rendezVous1 -> rendezVous1.getDateRDZ().after(date)).forEach(rendezVous -> log.info(rendezVous.getRemarque()));

    }
}