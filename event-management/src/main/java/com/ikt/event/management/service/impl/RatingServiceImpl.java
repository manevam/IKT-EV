package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.Rating;
import com.ikt.event.management.repository.RatingRepository;
import com.ikt.event.management.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating addRating(Integer rating) {
        Rating rating1 = new Rating(rating);
        return this.ratingRepository.save(rating1);
    }
}
