/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.service;

import fty.api.resto.model.Restaurant;
import fty.api.resto.model.Review;
import fty.api.resto.repository.RestaurantRepository;
import fty.api.resto.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author utilisateur
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;
    private ReviewRepository reviewRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository,
                                 ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Review createReview(Long restaurantId, Review reviewToCreate) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant.isPresent()) {
            reviewToCreate.setRestaurant(restaurant.get());
            return reviewRepository.save(reviewToCreate);
        } else {
            // On devrait renvoyer une exception
            return null;
        }
    }

    @Override
    public boolean deleteReview(Long restaurantId, Long reviewId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant.isPresent()) {
            List<Review> restReviews = restaurant.get().getReviews();

            boolean reviewExisting = false;
            for (Review restReview : restReviews) {
                if (restReview.getId() == reviewId) {
                    reviewExisting = true;
                    break;
                }
            }
            if (reviewExisting) {
                reviewRepository.deleteById(reviewId);
                return true;
            } else {
                return false;
            }
        } else {
            // On devrait renvoyer une exception
            return false;
        }
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(Integer lowestNote, Integer highestNote) {
        return restaurantRepository.findAllByReviewsNoteBetween(lowestNote, highestNote);
    }
    
}
