package com.exo1.exo1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheController {
    final private CacheManager cacheManager;

    @GetMapping
    public Map<String, Object> getAllCaches() {
        Map<String, Object> caches = new HashMap<>();
        for (String cacheName : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(cacheName);
            if (cache != null) {
                caches.put(cacheName, cache.getNativeCache().toString());
            }
        }
        return caches;
    }
}