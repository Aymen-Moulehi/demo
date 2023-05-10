package com.esprit.demo.restaurant;

import com.esprit.demo.menu.Menu;
import com.esprit.demo.menu.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class RestaurantServiceImpl implements IRestaurantService {

    RestaurantRepository restaurantRepository;
    MenuRepository menuRepository;

    @Override
    public Restaurant ajouterRestaurantEtAssocie(Restaurant restaurant) {
        List<Menu> menus = new ArrayList<>();
        restaurant.getMenus().forEach(
                menu -> menus.add(menuRepository.save(menu))
        );
        restaurant.setMenus(menus);
        return restaurantRepository.save(restaurant);
    }


}