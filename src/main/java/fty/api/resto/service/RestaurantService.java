/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.service;

import fty.api.resto.model.Restaurant;
import fty.api.resto.model.Review;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author utilisateur
 */
@Service
public interface RestaurantService {
    
    /**
     * Get the complete list of restaurants.
     *
     * @return the complete list from persistence layer.
     */
    List<Restaurant> getRestaurants();

    /**
     * Get the filtered list of restaurants regarding reviews.
     *
     * @return the filtered list from persistence layer.
     */
    List<Restaurant> getFilteredRestaurants(Integer lowestNote, Integer highestNote);

    /**
     * Restaurant review creation method.
     *
     * @param restaurantId the restaurant on which to link the review
     * @param reviewToCreate the review to create
     * @return the createdReview
     */
    Review createReview(Long restaurantId, Review reviewToCreate);

    /**
     * Review removal method
     *
     * @param restaurantId the linked restaurant
     * @param reviewId the review id to remove
     * @return true if removal possible, false otherwise
     */
    boolean deleteReview(Long restaurantId, Long reviewId);
}
