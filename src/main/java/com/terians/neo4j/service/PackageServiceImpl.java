package com.terians.neo4j.service;

import com.terians.dto.PackagesDTO;
import com.terians.neo4j.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository repository;

    @Override
    public Integer findPackageCountByScan(String teriansId) {
        return null;
    }

    @Override
    public PackagesDTO findPackagesByScanOrderedByAfferentCount(String teriansId, int limit) {
        return null;
    }

    @Override
    public PackagesDTO findPackagesByScanOrderedByEfferentCount(String teriansId, int limit) {
        return null;
    }
}
