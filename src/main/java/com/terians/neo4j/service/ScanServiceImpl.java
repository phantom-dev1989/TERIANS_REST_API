package com.terians.neo4j.service;

import com.terians.dto.*;
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
    public ScansDTO findAllScans() {
        return null;
    }

    @Override
    public ScanDTO findScan(String id, String metric, String teriansId) {
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

    @Override
    public IssuesDTO findAllIssues(String scanId, String category, String orderedBy) {
        return null;
    }

    @Override
    public IssueDTO findIssue(String scanId, String issueId) {
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String scanId) {
        return null;
    }

    @Override
    public DependencyDTO findDependency(String scanId, String dependencyId) {
        return null;
    }

    @Override
    public MethodsDTO findAllDependencyMethods(String scanId, String dependencyId) {
        return null;
    }

    @Override
    public MethodDTO findDependencyMethod(String scanId, String dependencyId, String methodId) {
        return null;
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String scanId, String dependencyId) {
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String scanId, String dependencyId, String relatedDependencyId) {
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String scanId, String dependencyId) {
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String scanId, String dependencyId, String vulnerabilityId) {
        return null;
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String scanId, String dependencyId, String category, String orderedBy) {
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String scanId, String dependencyId, String issueId) {
        return null;
    }

    @Override
    public PackagesDTO findAllPackges(String scanId) {
        return null;
    }

    @Override
    public PackageDTO findPackge(String scanId, String packageId) {
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String scanId, String packageId) {
        return null;
    }

    @Override
    public ClazzDTO findClazz(String scanId, String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String scanId, String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodDTO findMethod(String scanId, String packageId, String clazzId, String methodId) {
        return null;
    }

}
