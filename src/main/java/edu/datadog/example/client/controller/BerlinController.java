package edu.datadog.example.client.controller;

import com.timgroup.statsd.StatsDClient;
import edu.datadog.example.client.service.RandomContributorService;
import edu.datadog.example.client.util.Contributors;
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

    private RandomContributorService randomContributorService;
    private StatsDClient statsDClient;

    public BerlinController(RandomContributorService randomContributorService, StatsDClient statsDClient) {
        this.randomContributorService = randomContributorService;
        this.statsDClient = statsDClient;
    }

    @GetMapping("/contributors")
    public String listContributors(@RequestParam(value = "greeting", required = false) String greeting) {
        final String fGreeting = greeting == null || greeting.isEmpty() ? "Hello!!!" : greeting;
        log.info("{}, these are the contributors: ", Arrays.toString(Contributors.BERLIN_CONTRIBUTORS));

        statsDClient.incrementCounter("list.berlin.contributor.count");
        return String.format("%s, these are the contributors: %s", fGreeting, Arrays.toString(Contributors.BERLIN_CONTRIBUTORS));
    }

    @GetMapping("/best-contributor")
    public String theBest() {
        log.error("Not supported exception...");
        throw new UnsupportedOperationException("The whole team is good!!");
    }

    @GetMapping("/random-contributor")
    public String randomContributor() {
        log.info("calling random controller...");
        return randomContributorService.randomContributor();
    }
}
