package com.terians.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/data/scans")
public class ScansController {

    private static final Logger logger = LoggerFactory.getLogger(ScansController.class);
}
