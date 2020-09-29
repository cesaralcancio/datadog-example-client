package com.payclip.datadog.simple.datadogexampleclient.controller;

import com.payclip.datadog.simple.datadogexampleclient.service.RandomContributor;
import com.payclip.datadog.simple.datadogexampleclient.util.Contributors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/berlin")
public class BerlinController {

    private RandomContributor randomContributor;

    public BerlinController(RandomContributor randomContributor) {
        this.randomContributor = randomContributor;
    }

    @GetMapping("/contributors")
    public String listContributors(@RequestParam(value = "greeting", required = false) String greeting) {
        final String fGreeting = greeting == null || greeting.isEmpty() ? "Hello!!!" : greeting;
        log.info("{} ", fGreeting);
        log.info("{}, these are the contributors: ", Arrays.toString(Contributors.BERLIN_CONTRIBUTORS));
        return String.format("%s, thesse are the contributors: %s", fGreeting, Arrays.toString(Contributors.BERLIN_CONTRIBUTORS));
    }

    @GetMapping("/best-contributor")
    public String theBest() {
        log.error("Not supported exception...");
        throw new UnsupportedOperationException("The whole team is good!!");
    }

    @GetMapping("/random-contributor")
    public String randomContributor() {
        return randomContributor.randomContributor();
    }
}
