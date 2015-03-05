package com.terians.rest.controller;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/issues")
public class IssuesController {

    private static final Logger logger = LoggerFactory.getLogger(IssuesController.class);

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public IssuesDTO getIssues(@RequestParam(value="category", required=false) String category,
                               @RequestParam(value="orderedBy", required=false) String orderedBy) {

        String[] orderedByValues = orderedBy.split(",");
        String orderedByValue = orderedByValues[0];


        return null;
    }

    @RequestMapping(value ="/{issueId}", method = RequestMethod.GET)
    public IssueDTO getIssue(@PathVariable("issueId") String issueId) {


        return null;
    }
}
