package com.terians.rest.controller;

import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.neo4j.service.MethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stromero on 3/4/2015.
 */
@RestController
@RequestMapping("/api/v1/methods")
public class MethodsController {

    private static final Logger logger = LoggerFactory.getLogger(MethodsController.class);

    @Autowired
    private MethodService methodService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public MethodsDTO getMethods() {

        return methodService.findAllMethods();
    }

    @RequestMapping(value = "/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("methodId") String methodId) {

        return methodService.findMethod(methodId);
    }
}
