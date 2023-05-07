package com.esprit.demo.user;


import com.esprit.demo.contrat.Contrat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Temporal (TemporalType.DATE)
    private Date bithDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany
    List<Contrat> contrats;
}
