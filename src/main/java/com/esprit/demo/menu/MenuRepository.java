package com.esprit.demo.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findFirstByLibelleMenu(String libelleMenu);

    List<Menu> findAllByTypeMenu(TypeMenu typeMenu);
}
