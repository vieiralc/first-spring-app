package com.sprint_tutorial.first_spring_app.controller;

import com.sprint_tutorial.first_spring_app.domain.User;
import com.sprint_tutorial.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
        return this.helloWorldService.helloWorld("Lucas");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id,
                                 @RequestParam(value = "filter", defaultValue = "name") String filter,
                                 @RequestBody User body) {
        return "Hello World Post " + body.getName() + " id: " + id + " filter: " + filter;
    }
}
