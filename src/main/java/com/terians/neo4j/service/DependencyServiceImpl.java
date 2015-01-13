package com.terians.neo4j.service;

import com.terians.neo4j.model.Dependency;
import com.terians.neo4j.repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private DependencyRepository repository;

    @Override
    @Transactional
    public Set<Dependency> findByScanId(String scanId){

        return repository.findByScanId(scanId);
    }

    @Override
    @Transactional
    public Dependency findByTeriansId(String dependencyId){

        return repository.findByTeriansId(dependencyId);
    }

    @Override
    @Transactional
    public Dependency save(Dependency dependency){

        return repository.save(dependency);
    }
}
