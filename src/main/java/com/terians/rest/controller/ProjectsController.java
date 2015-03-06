package com.terians.rest.controller;

import com.terians.dto.*;
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

        return projectService.findProjectById(projectId);
    }

    @RequestMapping(value ="/{projectId}/scans", method = RequestMethod.GET)
    public ScansDTO getScans(@PathVariable("projectId") String projectId) {

        return projectService.findAllScansByProject(projectId);
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}", method = RequestMethod.GET)
    public ScanDTO getScan(@PathVariable("projectId") String projectId,
                           @PathVariable("scanId") String scanId,
                           @RequestParam(value="metric", required=false) String metric,
                           @RequestParam(value="scanned", required=false) String scanned) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("projectId") String projectId,
                                           @PathVariable("scanId") String scanId) {

        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("projectId") String projectId,
                                       @PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                           @PathVariable("scanId") String scanId,
                                           @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                                         @PathVariable("scanId") String scanId,
                                         @PathVariable("dependencyId") String dependencyId,
                                         @PathVariable("methodId") String methodId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("projectId") String projectId,
                                                  @PathVariable("scanId") String scanId,
                                                  @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/dependencies/{dependencyId2}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("projectId") String projectId,
                                              @PathVariable("scanId") String scanId,
                                              @PathVariable("dependencyId") String dependencyId,
                                              @PathVariable("dependencyId2") String dependencyId2) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("projectId") String projectId,
                                                 @PathVariable("scanId") String scanId,
                                                 @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("projectId") String projectId,
                                             @PathVariable("scanId") String scanId,
                                             @PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                                         @PathVariable("scanId") String scanId,
                                         @PathVariable("dependencyId") String dependencyId,
                                         @RequestParam(value="category", required=false) String category,
                                         @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                                       @PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("issueId") String issueId) {

        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages", method = RequestMethod.GET)
    public PackagesDTO getPackages(@PathVariable("projectId") String projectId,
                                   @PathVariable("scanId") String scanId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("projectId") String projectId,
                             @PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {


        return null;
    }

}
