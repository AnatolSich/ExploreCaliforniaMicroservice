package com.example.explore.exploreCalifornia.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="tour_rating")
public class TourRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    protected TourRating() {
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
     */
    public TourRating(Tour tour, Integer customerId, Integer score, String comment) {
        this.tour = tour;
        this.customerId = customerId;
        this.score = score;
        this.comment = comment;
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     */
    public TourRating(Tour tour, Integer customerId, Integer score) {
        this.tour = tour;
        this.customerId = customerId;
        this.score = score;
        this.comment = toComment(score);
    }

    /**
     * Auto Generate a message for a score.
     *
     * @param score
     * @return
     */
    private String toComment(Integer score) {
        switch (score) {
            case 1:return "Terrible";
            case 2:return "Poor";
            case 3:return "Fair";
            case 4:return "Good";
            case 5:return "Great";
            default: return score.toString();
        }
    }
}
