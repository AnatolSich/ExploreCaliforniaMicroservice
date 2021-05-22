package com.example.explore.exploreCalifornia.service;

import com.example.explore.exploreCalifornia.domain.TourPackage;
import com.example.explore.exploreCalifornia.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code code of the package
     * @param name name of the package
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {
        return !tourPackageRepository.existsById(code) ?
                tourPackageRepository.save(new TourPackage(code, name)) :
                null;

    }

    /**
     * Lookup All Tour packages
     *
     * @return
     */
    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }

    public long total() {
        return tourPackageRepository.count();
    }
}

