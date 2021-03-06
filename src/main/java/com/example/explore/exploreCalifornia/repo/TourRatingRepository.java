package com.example.explore.exploreCalifornia.repo;


import com.example.explore.exploreCalifornia.domain.TourRating;
import com.example.explore.exploreCalifornia.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    /**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
     */
    List<TourRating> findByPkTourId(Integer tourId);

    /**
     * Lookup a TourRating by the TourId and Customer Id
     *
     * @param tourId     tour identifier
     * @param customerId customer identifier
     * @return Optional of found TourRatings.
     */
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);

    /**
     * Fetch a Page of TourRatings
     *
     * @param tourId   the tour identifier
     * @param pageable info to determine page
     * @return Page of Tour Ratings
     */
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
}