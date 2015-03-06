package com.terians.neo4j.service;


import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface DependencyService {

    // Find all dependencies by Scan teriansId
    public DependenciesDTO findDependenciesByScan(String scanId);

    public DependenciesDTO findAllDependencies();

    public DependencyDTO findDependencyById(String dependencyId);

    public MethodsDTO findAllMethods(String dependencyId);

    public MethodDTO findMethodById(String dependencyId , String methodId);

    public DependenciesDTO findAllRelatedDependencies(String dependencyId);

    public DependencyDTO findRelatedDependencyById(String dependencyId, String relatedDependencyId);

    public VulnerabilitiesDTO findAllVulnerabilities(String dependencyId);

    public VulnerabilityDTO findVulnerabilityById(String dependencyId, String vulnerabilityId);

    public IssuesDTO findAllIssues(String dependencyId);

    public IssueDTO findIssueById(String dependencyId, String issueId);
}

