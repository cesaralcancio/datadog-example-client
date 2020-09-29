package edu.datadog.example.client.config;

import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;
import datadog.trace.api.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class StatsDConfig {

    @Bean
    public StatsDClient statsDClient() {
        return new NonBlockingStatsDClientBuilder()
                .prefix("datadog.example.client")
                .hostname("localhost")
                .port(8125)
                .build();
    }

    @Trace
    @Bean
    public void testTrace() {
      log.info("Running the @trace...");
    }

    @Trace(operationName = "custom.annotation")
    @Bean
    public void testTraceOtherName() {
        log.info("Running the custom @trace");
    }
}
