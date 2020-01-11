package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting updateGreeting(long id, User user);

    List<Greeting> getAllGreetings();

    void deleteById(long id);

    Greeting getGreetingById(long id);
}
