package com.esprit.demo.patient;


import com.esprit.demo.rendezvous.RendezVous;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;

    private String nomPatient;
    private int telephone;
    private Date dateNaissance;

    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous;
}
