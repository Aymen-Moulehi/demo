package com.esprit.demo.menu;

import java.util.List;

public interface IMenuService {
    Menu addMenu(Menu menu);

    List<String> libelleMenuParTypeMenuOrdonneParPrixTotal(TypeMenu typeMenu);
}