package com.terians.neo4j.service;

import com.terians.dto.ScanDTO;
import com.terians.dto.ScansDTO;
import com.terians.neo4j.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ScanServiceImpl implements ScanService {

    @Autowired
    private ScanRepository repository;


    @Override
    public ScanDTO findLatestScan() {
        return null;
    }

    @Override
    public ScansDTO findAllScansByProject(String teriansId) {
        return null;
    }

    @Override
    public ScanDTO findScanById(String teriansId) {
        return null;
    }

    @Override
    public Integer findComplexityByScan(String teriansId) {
        return null;
    }

    @Override
    public Integer findTechDebtByScan(String teriansId) {
        return null;
    }

    @Override
    public Integer findAbstractnessByScan(String teriansId) {
        return null;
    }

    @Override
    public Integer findInstabilityByScan(String teriansId) {
        return null;
    }
}
