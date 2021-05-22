package com.example.explore.exploreCalifornia.web;


import com.example.explore.exploreCalifornia.domain.TourRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class RatingDto {

    @Min(value = 0, message = "Score should not be less than 0")
    @Max(value = 5, message = "Score should not be greater than 5")
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    protected RatingDto() {
    }

}
