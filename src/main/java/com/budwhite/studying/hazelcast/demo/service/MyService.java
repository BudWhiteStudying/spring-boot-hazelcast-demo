package com.budwhite.studying.hazelcast.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private CacheManager cacheManager;

    @Cacheable("resource")
    public String waitThenSayHello() throws InterruptedException {
        Thread.sleep(2000);
        return "Hello";
    }

    public boolean clearResourceCache() {
        return cacheManager.getCache("resource").invalidate();
    }
}
