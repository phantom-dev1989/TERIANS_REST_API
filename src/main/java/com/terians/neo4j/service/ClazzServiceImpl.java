package com.terians.neo4j.service;

import com.terians.neo4j.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository repository;

}
