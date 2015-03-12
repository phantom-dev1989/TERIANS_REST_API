package com.terians.rest.controller;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import com.terians.neo4j.service.IssueService;
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
@RequestMapping("/api/v1/issues")
public class IssuesController {

    private static final Logger logger = LoggerFactory.getLogger(IssuesController.class);

    @Autowired
    private IssueService issueService;

    @RequestMapping(method = RequestMethod.GET)
    public IssuesDTO getIssues() {

        return issueService.findAllIssues();
    }

    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("issueId") String issueId) {

        return issueService.findIssue(issueId);
    }
}
