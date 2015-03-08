package com.terians.neo4j.service;


import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Project;
import com.terians.neo4j.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectsDTO findAllProjects() {
        return DTOTransformerUtil.transformProjectSetToProjectsDTO(projectRepository.findAllProjects());
    }

    @Override
    public ProjectDTO findProject(String projectId) {
        return DTOTransformerUtil.transformProjectToProjectDTO(projectRepository.findProjectById(projectId));
    }

    @Override
    public ScansDTO findAllScans(String projectId) {

        Project project = projectRepository.findProjectById(projectId);
        template.fetch(project.getScans());
        return DTOTransformerUtil.transformScanSetToScansDTO(project.getScans());
    }

    @Override
    public ScanDTO findScan(String projectId, String scanId, String metric, String scanned) {
        return null;
    }

    @Override
    public IssuesDTO findAllIssues(String projectId, String scanId, String category, String orderedBy) {
        return null;
    }

    @Override
    public IssueDTO findIssue(String projectId, String scanId, String issueId) {
        return null;
    }

    @Override
    public DependenciesDTO findAllDependencies(String projectId, String scanId) {
        return null;
    }

    @Override
    public DependencyDTO findDependeny(String projectId, String scanId, String dependencyId) {
        return null;
    }

    @Override
    public MethodsDTO findAllDependenyMethods(String projectId, String scanId, String dependencyId) {
        return null;
    }

    @Override
    public MethodDTO findDependenyMethod(String projectId, String scanId, String dependencyId, String methodId) {
        return null;
    }

    @Override
    public DependenciesDTO findAllRelatedDependencies(String projectId, String scanId, String dependencyId) {
        return null;
    }

    @Override
    public DependencyDTO findRelatedDependency(String projectId, String scanId, String dependencyId, String relatedDependencyId) {
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String projectId, String scanId, String dependencyId) {
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String projectId, String scanId, String dependencyId, String vulnerabilityId) {
        return null;
    }

    @Override
    public IssuesDTO findAllDependencyIssues(String projectId, String scanId, String dependencyId, String category, String orderedBy) {
        return null;
    }

    @Override
    public IssueDTO findDependencyIssue(String projectId, String scanId, String dependencyId, String issueId) {
        return null;
    }

    @Override
    public PackagesDTO findAllPackages(String projectId, String scanId) {
        return null;
    }

    @Override
    public PackageDTO findPackage(String projectId, String scanId, String packageId) {
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String projectId, String scanId, String packageId) {
        return null;
    }

    @Override
    public ClazzDTO findClazz(String projectId, String scanId, String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String projectId, String scanId, String packageId, String clazzId) {
        return null;
    }

    @Override
    public MethodDTO findMethod(String projectId, String scanId, String packageId, String clazzId, String methodId) {
        return null;
    }

}
