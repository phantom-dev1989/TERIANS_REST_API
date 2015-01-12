package com.terians.neo4j.service;

import com.terians.neo4j.repository.Neo4JSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by stromero on 12/2/2014.
 */
@Service
@Transactional
public class Neo4JSampleServiceImpl implements Neo4JSampleService{

    @Autowired
    private Neo4JSampleRepository repository;

    @Override
    public List<Object> findAllObjects(String string) {
        return repository.findAllObjects(string);
    }
}
