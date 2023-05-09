package com.esprit.demo.rendezvous;

import com.esprit.demo.medecin.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {

}
