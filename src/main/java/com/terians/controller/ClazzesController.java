package com.terians.controller;

import com.terians.dto.ClazzDTO;
import com.terians.dto.ClazzesDTO;
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
@RequestMapping("/api/v1/clazzes")
public class ClazzesController {

    private static final Logger logger = LoggerFactory.getLogger(ClazzesController.class);

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ClazzesDTO getClazzes() {


        return null;
    }

    @RequestMapping(value ="/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodsDTO getMethod(@PathVariable("clazzId") String clazzId,
                                @PathVariable("methodId") String methodId ) {

        return null;
    }
}
