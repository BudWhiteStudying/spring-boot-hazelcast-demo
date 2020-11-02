package com.budwhite.studying.hazelcast.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "resource", key = "#greetingRecipient")
    public String waitThenSayHello(String greetingRecipient) throws InterruptedException {
        Thread.sleep(2000);
        return "Hello " + greetingRecipient;
    }

    public boolean clearResourceCache() throws Exception {
        return Optional.ofNullable(
                cacheManager.getCache("resource"))
                .orElseThrow(()->new Exception("'resource' cache not found"))
                .invalidate();
    }
}
