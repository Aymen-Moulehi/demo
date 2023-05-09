package com.esprit.demo.clinique;


import com.esprit.demo.medecin.Medecin;
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
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClinique;

   private String nomClinique;
   private String adresse;
   private int telephne;

   @ManyToMany(mappedBy = "cliniques")
   private List<Medecin> medecins;
}
