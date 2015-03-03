package com.terians.neo4j.service;


import com.terians.dto.DependenciesDTO;
import com.terians.dto.DependencyDTO;
import com.terians.neo4j.model.Dependency;

/**
 * Created by stromero on 1/4/2015.
 */
public interface DependencyService {

    // Find all dependencies by Scan teriansId
    public DependenciesDTO findByScan(String teriansId);

    public DependencyDTO findById(String dependencyId);

    public Dependency save(Dependency dependency);
}

