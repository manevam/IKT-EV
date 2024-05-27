package com.ikt.event.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company extends BaseEntity{

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Rating> ratings;
    Double averageRating;

    public Double getAverageRating() {
        if (this.ratings.isEmpty())
            return 0.0;
        else {
            int sum = this.ratings.stream().mapToInt(Rating::getRating).sum();
            return ((double) sum / this.ratings.size());
        }
    }

    public Company(String companyName, String companyEmail) {
        this.name = companyName;
        this.email = companyEmail;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
