package com.example.explore.exploreCalifornia.web;


import com.example.explore.exploreCalifornia.domain.TourRating;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RatingDto {

    @Min(value = 0, message = "Score should not be less than 0")
    @Max(value = 5, message = "Score should not be greater than 5")
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    /**
     * Construct a RatingDto from a fully instantiated TourRating.
     *
     * @param tourRating Tour Rating Object
     */
    public RatingDto(TourRating tourRating) {
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    /**
     * Constructor to fully initialize the RatingDto
     *
     * @param score      score 0-5
     * @param comment    comment
     * @param customerId customer identifier
     */
    public RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto() {
    }

}
