package com.terians.neo4j.service;

import com.terians.neo4j.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class MethodServiceImpl implements MethodService {

    @Autowired
    private MethodRepository repository;

    @Override
    public Integer findMethodCountByScan(String teriansId) {
        return repository.findMethodCountByScan(teriansId);
    }
}
