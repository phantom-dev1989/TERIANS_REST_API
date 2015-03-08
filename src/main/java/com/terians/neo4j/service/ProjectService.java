package com.terians.neo4j.service;

import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ProjectService {

    ProjectsDTO findAllProjects();

    ProjectDTO findProject(String projectId);

    ScansDTO findAllScans(String projectId);

    ScanDTO findScan(String projectId, String scanId, String metric, String scanned);

    IssuesDTO findAllIssues(String projectId, String scanId, String category, String orderedBy);

    IssueDTO findIssue(String projectId, String scanId, String issueId);

    DependenciesDTO findAllDependencies(String projectId, String scanId);

    DependencyDTO findDependeny(String projectId, String scanId, String dependencyId);

    MethodsDTO findAllDependenyMethods(String projectId, String scanId, String dependencyId);

    MethodDTO findDependenyMethod(String projectId, String scanId, String dependencyId, String methodId);

    DependenciesDTO findAllRelatedDependencies(String projectId, String scanId, String dependencyId);

    DependencyDTO findRelatedDependency(String projectId, String scanId, String dependencyId, String relatedDependencyId);

    VulnerabilitiesDTO findAllVulnerabilities(String projectId, String scanId, String dependencyId);

    VulnerabilityDTO findVulnerability(String projectId, String scanId, String dependencyId, String vulnerabilityId);

    IssuesDTO findAllDependencyIssues(String projectId, String scanId, String dependencyId, String category, String orderedBy);

    IssueDTO findDependencyIssue(String projectId, String scanId, String dependencyId, String issueId);

    PackagesDTO findAllPackages(String projectId, String scanId);

    PackageDTO findPackage(String projectId, String scanId, String packageId);

    ClazzesDTO findAllClazzes(String projectId, String scanId, String packageId);

    ClazzDTO findClazz(String projectId, String scanId, String packageId, String clazzId);

    MethodsDTO findAllMethods(String projectId, String scanId, String packageId, String clazzId);

    MethodDTO findMethod(String projectId, String scanId, String packageId, String clazzId, String methodId);
}
