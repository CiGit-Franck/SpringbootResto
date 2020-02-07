/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.repository;

import fty.api.resto.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utilisateur
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
}
