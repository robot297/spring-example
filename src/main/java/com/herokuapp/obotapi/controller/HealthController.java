package com.herokuapp.obotapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static final Logger LOG = LoggerFactory.getLogger(HealthController.class);

    @GetMapping(path = "/health")
    public String healthCheck(){
        LOG.info("Health endpoint triggered.");
        return "App is OK";
    }
}
