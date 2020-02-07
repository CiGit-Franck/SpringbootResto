/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.service;

import fty.api.resto.model.Review;
import fty.api.resto.repository.ReviewRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author utilisateur
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review reviewToCreate) {
        return reviewRepository.save(reviewToCreate);
    }
}
