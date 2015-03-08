package com.terians.neo4j.service;

import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ScanService {

    // Find the latest Scan in a Project by date
    ScanDTO findLatestScan();

    ScansDTO findAllScans();

    ScanDTO findScan(String id, String metric, String scanId);

    Integer findComplexityByScan(String scanId);

    Integer findTechDebtByScan(String scanId);

    Integer findAbstractnessByScan(String scanId);

    Integer findInstabilityByScan(String scanId);

    IssuesDTO findAllIssues(String scanId, String category, String orderedBy);

    IssueDTO findIssue(String scanId, String issueId);

    DependenciesDTO findAllDependencies(String scanId);

    DependencyDTO findDependency(String scanId, String dependencyId);

    MethodsDTO findAllDependencyMethods(String scanId, String dependencyId);

    MethodDTO findDependencyMethod(String scanId, String dependencyId, String methodId);

    DependenciesDTO findAllRelatedDependencies(String scanId, String dependencyId);

    DependencyDTO findRelatedDependency(String scanId, String dependencyId, String relatedDependencyId);

    VulnerabilitiesDTO findAllVulnerabilities(String scanId, String dependencyId);

    VulnerabilityDTO findVulnerability(String scanId, String dependencyId, String vulnerabilityId);

    IssuesDTO findAllDependencyIssues(String scanId, String dependencyId, String category, String orderedBy);

    IssueDTO findDependencyIssue(String scanId, String dependencyId, String issueId);

    PackagesDTO findAllPackges(String scanId);

    PackageDTO findPackge(String scanId, String packageId);

    ClazzesDTO findAllClazzes(String scanId, String packageId);

    ClazzDTO findClazz(String scanId, String packageId, String clazzId);

    MethodsDTO findAllMethods(String scanId, String packageId, String clazzId);

    MethodDTO findMethod(String scanId, String packageId, String clazzId, String methodId);
}
