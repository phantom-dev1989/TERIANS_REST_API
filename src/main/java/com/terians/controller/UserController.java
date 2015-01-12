package com.terians.controller;


import com.terians.jpa.service.TeriansUserService;
import com.terians.jpa.model.TeriansUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 9/21/2014.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    // Use Service instead
    @Autowired
    private TeriansUserService teriansUserService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean createUser(@RequestBody TeriansUser teriansUser) {

        teriansUser.getRoles().add("ROLE_USER");
        teriansUser.getRoles().add("ROLE_ADMIN");

        teriansUserService.save(teriansUser);

        return true;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public TeriansUser getUser(@PathVariable("name") String name) {

        return teriansUserService.findByUsername(name);
    }
}
