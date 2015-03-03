package com.terians.neo4j.service;

import com.terians.dto.PackagesDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface PackageService {

    public Integer findPackageCountByScan(String teriansId);

    public PackagesDTO findPackagesByScanOrderedByAfferentCount(String teriansId, int limit);

    public PackagesDTO findPackagesByScanOrderedByEfferentCount(String teriansId, int limit);

}

