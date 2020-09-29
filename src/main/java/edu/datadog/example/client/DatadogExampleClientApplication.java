package edu.datadog.example.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DatadogExampleClientApplication {

    public static void main(String[] args) {
        String DddServiceName = System.getProperty("dd.service.name");
        log.info("DddServiceName: {}", DddServiceName);
        log.info("{} {}", args[0], args[1]);
        SpringApplication.run(DatadogExampleClientApplication.class, args);
    }
}
