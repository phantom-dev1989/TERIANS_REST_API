package com.terians.controller;

import com.terians.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/dependencies")
public class DependenciesController {

    private static final Logger logger = LoggerFactory.getLogger(DependenciesController.class);

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public DependenciesDTO getDependencies() {

        return null;
    }

    @RequestMapping(value ="/{dependencyId}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/dependencies", method = RequestMethod.GET)
    public DependenciesDTO getDependencies(@PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/dependencies/{dependencyId2}", method = RequestMethod.GET)
    public DependencyDTO getDependency(@PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("dependencyId2") String dependencyId2) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities(@PathVariable("dependencyId") String dependencyId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("dependencyId") String dependencyId,
                                             @PathVariable("vulnerabilityId") String vulnerabilityId) {


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/issues", method = RequestMethod.GET)
    public IssuesDTO getIssues(@PathVariable("dependencyId") String dependencyId,
                               @RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {


        return null;
    }
}
