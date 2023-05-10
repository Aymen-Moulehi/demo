package com.esprit.demo.client;


import com.esprit.demo.menu.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String identifiant;
    private Date datePremiereVisite;

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private List<Menu> menus;
}
