package edu.datadog.example.client.controller;

import edu.datadog.example.client.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataDogHelloWorldController {

    private HelloWorldService helloWorldService;

    public DataDogHelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public String helloWorld() {
        int d = (int) (Math.random() * 100);
        String helloWorldDataDog = helloWorldService.helloWorld();
        log.info("{} {}", helloWorldDataDog, d);
        return String.format("%s %s", helloWorldDataDog, d);
    }
}
