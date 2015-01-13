package com.terians.neo4j.service;

import com.terians.neo4j.model.Scan;
import com.terians.neo4j.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class ScanServiceImpl implements ScanService {

    @Autowired
    private ScanRepository repository;

    @Override
    @Transactional
    public Scan findLatestScanByMaxDate(){

        return repository.findLatestScanByMaxDate();
    }

    @Override
    @Transactional
    public Scan save(Scan scan){

        return repository.save(scan);
    }

}
