package com.terians.rest.controller;

import com.terians.dto.*;
import com.terians.neo4j.repository.IssueRepository;
import com.terians.neo4j.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ProjectsDTO getProjects() {

        return projectService.findAllProjects();
    }

    @RequestMapping(value ="/{projectId}", method = RequestMethod.GET)
    public ProjectDTO getProject(@PathVariable("projectId") String projectId) {

        return projectService.findProject(projectId);
    }

    @RequestMapping(value ="/{projectId}/scans", method = RequestMethod.GET)
    public ScansDTO getScans(@PathVariable("projectId") String projectId) {

        return projectService.findAllScans(projectId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}", method = RequestMethod.GET)
    public ScanDTO getScan(@PathVariable("projectId") String projectId,
                           @PathVariable("scanId") String scanId,
                           @RequestParam(value="scanned", required=false) String scanned) {

        return projectService.findScan(projectId, scanId, scanned);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId) {

        return projectService.findAllIssues(projectId, scanId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {

        return projectService.findIssue(projectId, scanId, issueId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("projectId") String projectId,
                                           @PathVariable("scanId") String scanId) {

        return projectService.findAllDependencies(projectId, scanId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("projectId") String projectId,
                                       @PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId) {

        return projectService.findDependeny(projectId, scanId, dependencyId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllDependenyMethods(projectId, scanId, dependencyId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {

        return projectService.findDependenyMethod(projectId, scanId, dependencyId, methodId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("projectId") String projectId,
                                           @PathVariable("scanId") String scanId,
                                           @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllRelatedDependencies(projectId, scanId, dependencyId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/dependencies/{relatedDependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("projectId") String projectId,
                                       @PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("relatedDependencyId") String relatedDependencyId) {

        return projectService.findRelatedDependency(projectId, scanId, dependencyId, relatedDependencyId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("projectId") String projectId,
                                                 @PathVariable("scanId") String scanId,
                                                 @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllVulnerabilities(projectId, scanId, dependencyId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("projectId") String projectId,
                                             @PathVariable("scanId") String scanId,
                                             @PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return projectService.findVulnerability(projectId, scanId, dependencyId, vulnerabilityId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        return projectService.findAllDependencyIssues(projectId, scanId, dependencyId, category, orderedBy);

    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {

        return projectService.findDependencyIssue(projectId, scanId, dependencyId, issueId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages", method = RequestMethod.GET)
    public PackagesDTO getPackages(@PathVariable("projectId") String projectId,
                                   @PathVariable("scanId") String scanId) {

        return projectService.findAllPackages(projectId, scanId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return projectService.findPackage(projectId, scanId, packageId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return projectService.findAllClazzes(projectId, scanId, packageId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {

        return projectService.findClazz(projectId, scanId, packageId, clazzId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {

        return projectService.findAllMethods(projectId, scanId, packageId, clazzId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return projectService.findMethod(projectId, scanId, packageId, clazzId, methodId);
    }

}
