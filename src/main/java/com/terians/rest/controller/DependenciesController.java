package com.terians.rest.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.DependencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/dependencies")
public class DependenciesController {

    private static final Logger logger = LoggerFactory.getLogger(DependenciesController.class);

    @Autowired
    private DependencyService dependencyService;

    @RequestMapping(method = RequestMethod.GET)
    public DependenciesDTO getDependencies() {

        return dependencyService.findAllDependencies();
    }

    @RequestMapping(value = "/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findDependency(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllMethods(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {

        return dependencyService.findMethod(dependencyId, methodId);
    }

    @RequestMapping(value = "/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllRelatedDependencies(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/dependencies/{relatedDependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("relatedDependencyId") String relatedDependencyId) {

        return dependencyService.findRelatedDependency(dependencyId, relatedDependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllVulnerabilities(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return dependencyService.findVulnerability(dependencyId, vulnerabilityId);
    }

    @RequestMapping(value = "/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllIssues(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {

        return dependencyService.findIssue(dependencyId, issueId);
    }
}
