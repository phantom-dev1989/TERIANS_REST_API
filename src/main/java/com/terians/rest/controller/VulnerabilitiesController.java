package com.terians.rest.controller;

import com.terians.dto.VulnerabilitiesDTO;
import com.terians.dto.VulnerabilityDTO;
import com.terians.neo4j.service.VulnerabilityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/v1/vulnerabilities")
@Api(value = "vulnerabilities", description = "Vulnerabilities API")
public class VulnerabilitiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VulnerabilitiesController.class);

    @Autowired
    private VulnerabilityService vulnerabilityService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerabilities", notes = "Returns all vulnerabilities")
    public VulnerabilitiesDTO getVulnerabilities() {

        return vulnerabilityService.findAllVulnerabilities();
    }

    @RequestMapping(value = "/{vulnerabilityId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerability", notes = "Returns a vulnerability by vulnerabilityId")
    public VulnerabilityDTO getVulnerability(@PathVariable("vulnerabilityId") String vulnerabilityId) {

        return vulnerabilityService.findVulnerability(vulnerabilityId);
    }
}
