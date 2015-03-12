package com.terians.rest.controller;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
import com.terians.dto.MethodDTO;
import com.terians.dto.MethodsDTO;
import com.terians.neo4j.service.ClazzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 3/4/2015.
 */
@RestController
@RequestMapping("/api/v1/clazzes")
public class ClazzesController {

    private static final Logger logger = LoggerFactory.getLogger(ClazzesController.class);

    @Autowired
    private ClazzService clazzService;

    // Needs to implement Query Parameter Logic
    @RequestMapping(method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@RequestParam(value = "category", required = false) String category) {

        return clazzService.findAllClazzes();
    }

    @RequestMapping(value = "/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("clazzId") String clazzId) {

        return clazzService.findClazz(clazzId);
    }

    @RequestMapping(value = "/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("clazzId") String clazzId) {

        return clazzService.findAllMethods(clazzId);
    }

    @RequestMapping(value = "/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return clazzService.findMethod(clazzId, methodId);
    }
}
