package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @PostMapping
    public ResponseEntity addGreeting(@RequestBody User user) {
        return ResponseEntity.ok(greetingService.addGreeting(user));
    }

    @PutMapping
    public ResponseEntity updateGreeting(@RequestBody User user, @RequestParam("id") long id){
        return ResponseEntity.ok(greetingService.updateGreeting(id,user));
    }

    @GetMapping
    public ResponseEntity getAllGreetings(){
        return ResponseEntity.ok(greetingService.getAllGreetings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGreetingById(@PathVariable("id") long id){
        greetingService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable("id") long id){
        return greetingService.getGreetingById(id);
    }
}
