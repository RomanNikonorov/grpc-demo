package ru.rnikonorov.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {

    public String greetClient(final String name) {
        return "Hello " + name;
    }
}
