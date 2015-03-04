package com.terians.controller;

import com.terians.dto.*;
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
@RequestMapping("/api/v1/packages")
public class PackagesController {

    private static final Logger logger = LoggerFactory.getLogger(PackagesController.class);

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public PackagesDTO getPackages() {


        return null;
    }

    @RequestMapping(value ="/{packageId}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{packageId}/clazzes", method = RequestMethod.GET)
    public ClazzesDTO getClazzes(@PathVariable("packageId") String packageId) {


        return null;
    }

    @RequestMapping(value ="/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    public ClazzDTO getClazz(@PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    public MethodsDTO getMethods(@PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {


        return null;
    }

    @RequestMapping(value ="/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    public MethodDTO getMethod(@PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {


        return null;
    }
}
