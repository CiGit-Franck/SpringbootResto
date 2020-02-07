/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.controler;

import fty.api.resto.model.Restaurant;
import fty.api.resto.model.Review;
import fty.api.resto.service.RestaurantService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantControler {
    
    private RestaurantService restaurantService;

    public RestaurantControler(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PostMapping("/{restaurantId}/reviews")
    public ResponseEntity<Review> addReviewToRestaurant(@PathVariable Long restaurantId, @RequestBody Review reviewToAdd) {
        Review createdReview = restaurantService.createReview(restaurantId, reviewToAdd);
        if (createdReview != null) {
            return ResponseEntity.ok(createdReview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{restaurantId}/reviews/{reviewIdToDelete}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long restaurantId, @PathVariable Long reviewIdToDelete) {
        boolean isDeletionPossible = restaurantService.deleteReview(restaurantId, reviewIdToDelete);
        if (isDeletionPossible) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
