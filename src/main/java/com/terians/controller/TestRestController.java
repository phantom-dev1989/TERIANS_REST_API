package com.terians.controller;

import com.terians.jpa.model.Hello;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api/data/message")
public class TestRestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value ="/{msg}", method = RequestMethod.GET)
    public Hello getMessage(@PathVariable("msg") String message){

        Hello messageObj = new Hello();
        messageObj.setId(counter.getAndIncrement());
        messageObj.setMessage(message);

        return messageObj;
    }
}

