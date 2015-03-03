package com.terians.neo4j.service;

import com.terians.dto.ScanDTO;
import com.terians.dto.ScansDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ScanService {

    // Find the latest Scan in a Project by date
    public ScanDTO findLatestScan();

    public ScansDTO findAllScansByProject(String teriansId);

    public ScanDTO findScanById(String teriansId);

    public Integer findComplexityByScan(String teriansId);

    public Integer findTechDebtByScan(String teriansId);

    public Integer findAbstractnessByScan(String teriansId);

    public Integer findInstabilityByScan(String teriansId);
}
