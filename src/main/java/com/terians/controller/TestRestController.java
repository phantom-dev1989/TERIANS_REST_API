package com.terians.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api/data/message")
public class TestRestController {

    private static final Logger logger = LoggerFactory.getLogger(TestRestController.class);

    private final AtomicLong counter = new AtomicLong();

/*    @RequestMapping(value ="/{msg}", method = RequestMethod.GET)
    public Hello getMessage(@PathVariable("msg") String message){

        Hello messageObj = new Hello();
        messageObj.setId(counter.getAndIncrement());
        messageObj.setMessage(message);

        return messageObj;

        @RequestMapping(value ="/{msg}", method = RequestMethod.GET)
    public Hello getMessage(@PathVariable("msg") String message, @RequestParam(value="page", required=false) String page){

        Hello messageObj = new Hello();
        messageObj.setId(counter.getAndIncrement());
        messageObj.setMessage(message);

        return messageObj;
    }
    }*/
}

