package com.esprit.demo.medecin;


import com.esprit.demo.clinique.Clinique;
import com.esprit.demo.rendezvous.RendezVous;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedecin;
    private String nomMedcien;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int telephone;
    private int prixConsultation;

    @ManyToMany
    private List<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}
