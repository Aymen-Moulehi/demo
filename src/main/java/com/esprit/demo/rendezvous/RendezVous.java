package com.esprit.demo.rendezvous;


import com.esprit.demo.medecin.Medecin;
import com.esprit.demo.patient.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRendezVous;

    private Date dateRDZ;
    private String remarque;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patient;
}
