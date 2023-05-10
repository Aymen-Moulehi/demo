package com.esprit.demo.menu;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuRestController {
    IMenuService menuService;

    @PostMapping("/add-menu")
    public Menu addMenuS(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }


    @GetMapping("libelleMenuParTypeMenuOrdonneParPrixTotal")
    public List<String> libelleMenuParTypeMenuOrdonneParPrixTotal(@RequestParam TypeMenu typeMenu){
        return menuService.libelleMenuParTypeMenuOrdonneParPrixTotal(typeMenu);
    }
}
