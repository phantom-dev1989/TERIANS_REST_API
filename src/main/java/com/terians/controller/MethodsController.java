package com.terians.controller;

import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public MethodsDTO getMethods() {


        return null;
    }

    @RequestMapping(value ="/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("methodId") String methodId) {


        return null;
    }
}
