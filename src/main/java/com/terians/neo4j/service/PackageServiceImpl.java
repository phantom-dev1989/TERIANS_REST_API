package com.terians.neo4j.service;

import com.terians.neo4j.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository repository;

}
