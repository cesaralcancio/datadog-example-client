package edu.datadog.example.client.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String helloWorld() {
        return "Hello World DataDog!!!";
    }
}
