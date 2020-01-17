package edu.minneapolis.springexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {
    private static Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public ResponseEntity<String> responder(){
        LOG.info("Post received.");

        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }
}
