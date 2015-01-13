package com.terians.neo4j.service;

import com.terians.neo4j.model.Dependency;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
public interface DependencyService {
    Set<Dependency> findByScanId(String scanId);
    Dependency findByTeriansId(String dependencyId);
    Dependency save(Dependency dependency);
}

