/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.model;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author utilisateur
 */
@Entity
public class Restaurant {

    @Id
    @SequenceGenerator(name = "restaurant_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer seats;
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;
    @OneToMany
    private List<Review> reviews = new ArrayList<>();
//    @ManyToMany
//    @JoinTable(name = "restaurants_visits", joinColums = @JoinColumn(name = "restaurant_id"), inverseJoinColums = @JoinColumn(name = "client_id"))
//    private Set<Client> visitors;
//
//    public Restaurant() {
//        this.visitors = new HashSet<>();
//    }
}
