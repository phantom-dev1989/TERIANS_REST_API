package com.terians.rest.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.ScanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/scans")
public class ScansController {

    private static final Logger logger = LoggerFactory.getLogger(ScansController.class);

    @Autowired
    private ScanService scanService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ScansDTO getScans() {

        return scanService.findAllScans();
    }

    @RequestMapping(value ="/{scanId}", method = RequestMethod.GET)
    public ScanDTO getScan(@PathVariable("scanId") String scanId,
                           @RequestParam(value="scanned", required=false) String scanned) {

        return scanService.findScan(scanId,scanned);
    }

    @RequestMapping(value ="/{scanId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("scanId") String scanId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy,
                               @RequestParam(value="limit", required=false) int limit) {

        return scanService.findAllIssues(scanId, category, orderedBy, limit);
    }

    @RequestMapping(value ="/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {

        return scanService.findIssue(scanId, issueId);
    }

    @RequestMapping(value ="/{scanId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("scanId") String scanId) {

        return scanService.findAllDependencies(scanId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId) {

        return scanService.findDependency(scanId, dependencyId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllDependencyMethods(scanId, dependencyId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {

        return scanService.findDependencyMethod(scanId, dependencyId, methodId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("scanId") String scanId,
                                           @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllRelatedDependencies(scanId, dependencyId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/dependencies/{relatedDependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("relatedDependencyId") String relatedDependencyId) {

        return scanService.findRelatedDependency(scanId, dependencyId, relatedDependencyId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("scanId") String scanId,
                                                 @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllVulnerabilities(scanId, dependencyId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("scanId") String scanId,
                                             @PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return scanService.findVulnerability(scanId, dependencyId, vulnerabilityId);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        return scanService.findAllDependencyIssues(scanId, dependencyId, category, orderedBy);
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("scanId") String scanId,
                             @PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {

        return scanService.findDependencyIssue(scanId, dependencyId, issueId);
    }

    @RequestMapping(value ="/{scanId}/packages", method = RequestMethod.GET)
    public PackagesDTO getPackages(@PathVariable("scanId") String scanId) {

        return scanService.findAllPackages(scanId);
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return scanService.findPackage(scanId, packageId);
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return scanService.findAllClazzes(scanId, packageId);
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("scanId") String scanId,
                             @PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {

        return scanService.findClazz(scanId, packageId, clazzId);
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {

        return scanService.findAllMethods(scanId, packageId, clazzId);
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return scanService.findMethod(scanId, packageId, clazzId, methodId);
    }
}
