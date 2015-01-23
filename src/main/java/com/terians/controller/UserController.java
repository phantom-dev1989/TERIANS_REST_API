package com.terians.controller;


import com.terians.jpa.service.TeriansUserService;
import com.terians.jpa.model.TeriansUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 9/21/2014.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Use Service instead
    @Autowired
    private TeriansUserService teriansUserService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean createUser(@RequestBody TeriansUser teriansUser) {

        teriansUser.getRoles().add("ROLE_USER");
        teriansUser.getRoles().add("ROLE_ADMIN");

        teriansUserService.save(teriansUser);

        logger.debug(teriansUser.getUsername());

        return true;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public TeriansUser getUser(@PathVariable("name") String name) {

        return teriansUserService.findByUsername(name);
    }
}
