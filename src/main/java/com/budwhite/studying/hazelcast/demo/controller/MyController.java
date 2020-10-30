package com.budwhite.studying.hazelcast.demo.controller;

import com.budwhite.studying.hazelcast.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("resource")
    public String getResource() throws InterruptedException {
        return myService.waitThenSayHello();
    }

    @DeleteMapping("cache")
    public boolean clearCache() {
        return myService.clearResourceCache();
    }
}
