package com.terians.neo4j.service;

import com.terians.dto.ScanDTO;
import com.terians.dto.ScansDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
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
        return DTOTransformerUtil.transformScanToScanDTO(repository.findLatestScan());
    }

    @Override
    public ScansDTO findAllScansByProject(String teriansId) {
        return DTOTransformerUtil.transformScanSetToScansDTO(repository.findAllScansByProject(teriansId));
    }

    @Override
    public ScanDTO findScanById(String teriansId) {
        return DTOTransformerUtil.transformScanToScanDTO(repository.findScanById(teriansId));
    }

    @Override
    public Integer findComplexityByScan(String teriansId) {
        return repository.findComplexityByScan(teriansId);
    }

    @Override
    public Integer findTechDebtByScan(String teriansId) {
        return repository.findTechDebtByScan(teriansId);
    }

    @Override
    public Integer findAbstractnessByScan(String teriansId) {
        return repository.findAbstractnessByScan(teriansId);
    }

    @Override
    public Integer findInstabilityByScan(String teriansId) {
        return repository.findInstabilityByScan(teriansId);
    }

}
