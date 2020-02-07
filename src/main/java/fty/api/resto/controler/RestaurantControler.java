/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.controler;

import fty.api.resto.model.Restaurant;
import fty.api.resto.repository.RestaurantRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantControler {
    
    private RestaurantRepository restaurantRepository;

    public RestaurantControler(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping()
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }
    
}
