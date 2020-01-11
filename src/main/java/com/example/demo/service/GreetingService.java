package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{

    @Autowired
    private GreetingRepository greetingRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user){
        String content = this.getContent(user);
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), content));
    }

    @Override
    public Greeting updateGreeting(long id, User user){
        String content = this.getContent(user);
        return greetingRepository.save(new Greeting(id,content));
    }

    private String getContent(User user){
        String content = template;
        if(user.getFirstName() != null)
            content = template.replace("%s",user.getFirstName());
        if(user.getLastName() != null)
            content = template.replace("%s",user.getLastName());
        if(user.getFirstName() != null && user.getLastName() != null)
            content = template.replace("%s",user.getFirstName()+" "+user.getLastName());
        if(user.getLastName() == null && user.getFirstName() == null)
            content = template.replace("%s","World");
        return content;
    }

    @Override
    public List<Greeting> getAllGreetings(){
        return greetingRepository.findAll();
    }

    @Override
    public void deleteById(long id){
        greetingRepository.deleteById(id);
    }

    @Override
    public Greeting getGreetingById(long id){
        return greetingRepository.findById(id).get();
    }
}
