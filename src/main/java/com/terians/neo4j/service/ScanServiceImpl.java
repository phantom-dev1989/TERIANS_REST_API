package com.terians.neo4j.service;

import com.terians.dto.ScanDTO;
import com.terians.dto.ScansDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ScanServiceImpl implements ScanService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private ScanRepository scanRepository;

    @Override
    public ScanDTO findLatestScan() {
        return DTOTransformerUtil.transformScanToScanDTO(scanRepository.findLatestScan());
    }

    @Override
    public ScansDTO findAllScansByProject(String teriansId) {
        return DTOTransformerUtil.transformScanSetToScansDTO(scanRepository.findAllScansByProject(teriansId));
    }

    @Override
    public ScanDTO findScanById(String teriansId) {
        return DTOTransformerUtil.transformScanToScanDTO(scanRepository.findScanById(teriansId));
    }

    @Override
    public Integer findComplexityByScan(String teriansId) {
        return scanRepository.findComplexityByScan(teriansId);
    }

    @Override
    public Integer findTechDebtByScan(String teriansId) {
        return scanRepository.findTechDebtByScan(teriansId);
    }

    @Override
    public Integer findAbstractnessByScan(String teriansId) {
        return scanRepository.findAbstractnessByScan(teriansId);
    }

    @Override
    public Integer findInstabilityByScan(String teriansId) {
        return scanRepository.findInstabilityByScan(teriansId);
    }

}
