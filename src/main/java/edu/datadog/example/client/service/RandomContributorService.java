package edu.datadog.example.client.service;

import edu.datadog.example.client.util.Contributors;
import com.timgroup.statsd.StatsDClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RandomContributorService {

    private StatsDClient statsDClient;

    public RandomContributorService(StatsDClient statsDClient) {
        this.statsDClient = statsDClient;
    }

    public String randomContributor() {
        log.info("randomContributor init");

        try {
            String[] contributors = Contributors.BERLIN_CONTRIBUTORS;
            double random = Math.random();
            int number = (int) (random * 10); //0 -> 10

            log.info("random number: {}", number);
            log.info("randomContributor finish: {}", contributors[number]);

            statsDClient.incrementCounter("random.contributor.count");
            return contributors[number];
        } catch (IndexOutOfBoundsException iobe) {
            log.error("Error finding custom contributor: {}", iobe.getMessage(), iobe);
            throw new RuntimeException(iobe);
        }
    }
}
