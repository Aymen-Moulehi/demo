package com.esprit.demo.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {
    IRestaurantService restaurantService;

    @PostMapping("/add-restaurant")
    public Restaurant ajouterRestaurantEtAssocie(@RequestBody Restaurant restaurant) {
        return restaurantService.ajouterRestaurantEtAssocie(restaurant);
    }
}
