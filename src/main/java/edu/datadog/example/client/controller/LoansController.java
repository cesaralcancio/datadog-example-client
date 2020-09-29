package edu.datadog.example.client.controller;

import com.timgroup.statsd.StatsDClient;
import edu.datadog.example.client.util.Contributors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Slf4j
@RequestMapping("/loans")
public class LoansController {

    private StatsDClient statsDClient;

    public LoansController(StatsDClient statsDClient) {
        this.statsDClient = statsDClient;
    }

    @GetMapping("/contributors")
    public String listContributors(@RequestParam(value = "greeting", required = false) String greeting) {
        final String fGreeting = greeting == null || greeting.isEmpty() ? "Hello!!!" : greeting;
        log.info("{}, these are the contributors: ", Arrays.toString(Contributors.LOANS_CONTRIBUTORS));

        statsDClient.incrementCounter("list.loans.contributor.count");
        return String.format("%s, these are the contributors: %s", fGreeting, Arrays.toString(Contributors.LOANS_CONTRIBUTORS));
    }
}
