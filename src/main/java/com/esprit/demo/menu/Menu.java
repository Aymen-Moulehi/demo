package com.esprit.demo.menu;


import com.esprit.demo.client.Client;
import com.esprit.demo.composant.Composant;
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
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    private String libelleMenu;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    private Float prixTotal;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Client> clients;
    @OneToMany(mappedBy = "menu")
    private List<Composant> composants;
}
