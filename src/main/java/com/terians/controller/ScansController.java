package com.terians.controller;

import com.terians.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/scans")
public class ScansController {

    private static final Logger logger = LoggerFactory.getLogger(ScansController.class);

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ScansDTO getScans() {


        return null;
    }

    @RequestMapping(value ="/{scanId}", method = RequestMethod.GET)
    public ScanDTO getScan(@PathVariable("scanId") String scanId,
                           @RequestParam(value="metric", required=false) String metric,
                           @RequestParam(value="scanned", required=false) String scanned) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("scanId") String scanId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("scanId") String scanId) {

        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getRelatedDependencies(@PathVariable("scanId") String scanId,
                                                  @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/dependencies/{dependencyId2}", method = RequestMethod.GET)
    public DependencyDTO getRelatedDependency(@PathVariable("scanId") String scanId,
                                              @PathVariable("dependencyId") String dependencyId,
                                              @PathVariable("dependencyId2") String dependencyId2) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("scanId") String scanId,
                                                 @PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("scanId") String scanId,
                                             @PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getDependencyIssues(@PathVariable("scanId") String scanId,
                                         @PathVariable("dependencyId") String dependencyId,
                                         @RequestParam(value="category", required=false) String category,
                                         @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getDependencyIssue(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("issueId") String issueId) {

        return null;
    }

    @RequestMapping(value ="/{scanId}/packages", method = RequestMethod.GET)
    public PackagesDTO getPackages(@PathVariable("scanId") String scanId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {


        return null;
    }
}
