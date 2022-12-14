package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StandardController {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public Mono<Map<String, String>> hello() {
        final Map<String, String> map = new HashMap<>();
        map.put("hi", "hi");
        return Mono.just(map);
    }
}