/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.repository;

import fty.api.resto.model.Restaurant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utilisateur
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT DISTINCT restaurant FROM Restaurant restaurant JOIN restaurant.reviews reviews where reviews.note >= :lowest and reviews.note <= :highest")
    List<Restaurant> findAllByReviewsNoteBetween(Integer lowest, Integer highest);
}
