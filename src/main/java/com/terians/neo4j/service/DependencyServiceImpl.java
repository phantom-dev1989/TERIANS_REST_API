package com.terians.neo4j.service;

import com.terians.dto.DependenciesDTO;
import com.terians.dto.DependencyDTO;
import com.terians.neo4j.model.Dependency;
import com.terians.neo4j.repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private DependencyRepository repository;


    @Override
    public DependenciesDTO findByScan(String teriansId) {
        return null;
    }

    @Override
    public DependencyDTO findById(String dependencyId) {
        return null;
    }

    @Override
    public Dependency save(Dependency dependency) {
        return null;
    }
}
