package com.terians.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 9/21/2014.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


/*    @RequestMapping(method = RequestMethod.POST)
    public boolean createUser(@RequestBody TeriansUser teriansUser) {


        return true;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public TeriansUser getUser(@PathVariable("name") String name) {

        return teriansUserService.findByUsername(name);
    }*/
}