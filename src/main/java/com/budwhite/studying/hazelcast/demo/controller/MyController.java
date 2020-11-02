package com.budwhite.studying.hazelcast.demo.controller;

import com.budwhite.studying.hazelcast.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("resource")
    public String getResource(@RequestParam String greetingRecipient) throws InterruptedException {
        return myService.waitThenSayHello(greetingRecipient);
    }

    @DeleteMapping("cache")
    public boolean clearCache() {
        try {
            return myService.clearResourceCache();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
