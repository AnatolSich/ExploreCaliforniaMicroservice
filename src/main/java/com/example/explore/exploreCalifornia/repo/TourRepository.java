package com.example.explore.exploreCalifornia.repo;

import com.example.explore.exploreCalifornia.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    /**
     * Find Tours associated with the Tour Package.
     *
     * @param code tour package code
     * @return List of found tours.
     */
    Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);
}
