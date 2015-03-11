package com.terians.rest.controller;

import com.terians.dto.VulnerabilitiesDTO;
import com.terians.dto.VulnerabilityDTO;
import com.terians.neo4j.service.VulnerabilityService;
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
public class VulnerabilitiesController {

    private static final Logger logger = LoggerFactory.getLogger(VulnerabilitiesController.class);

    @Autowired
    private VulnerabilityService vulnerabilityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public VulnerabilitiesDTO getVulnerabilities() {

        return vulnerabilityService.findAllVulnerabilities();
    }

    @RequestMapping(value = "/{vulnerabilityId}", method = RequestMethod.GET)
    public VulnerabilityDTO getVulnerability(@PathVariable("vulnerabilityId") String vulnerabilityId) {

        return vulnerabilityService.findVulnerability(vulnerabilityId);
    }
}
