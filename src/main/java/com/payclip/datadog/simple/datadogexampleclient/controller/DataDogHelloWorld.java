package com.payclip.datadog.simple.datadogexampleclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataDogHelloWorld {

    @GetMapping
    public String helloWorld() {
        double d = Math.random() * 100;
        log.info("Hello World DataDog!!! {}", (int) d);
        return "Hello World DataDog!!! " + (int) d;
    }
}
