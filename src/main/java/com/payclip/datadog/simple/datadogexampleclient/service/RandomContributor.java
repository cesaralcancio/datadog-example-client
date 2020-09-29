package com.payclip.datadog.simple.datadogexampleclient.service;

import com.payclip.datadog.simple.datadogexampleclient.util.Contributors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RandomContributor {

    public String randomContributor() {
        log.error("randomContributor init");
        String[] contributors = Contributors.BERLIN_CONTRIBUTORS;
        double random = Math.random();
        int number = (int) (random * 10); //0 - 10
        log.error("random number: {}", number);
        log.error("randomContributor finish: {}", contributors[number]);
        return contributors[number];
    }
}
