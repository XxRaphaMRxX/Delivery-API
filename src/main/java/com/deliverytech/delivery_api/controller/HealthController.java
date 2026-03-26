package com.deliverytech.delivery_api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now().toString(),
                "service", "Delivery Api",
                "javaversion", System.getProperty("java.version")


        );
    }

    @GetMapping("/info")
    public Appinfo  info() {
        return new Appinfo(
                "Delivery Tech Api",
                "1.0.0",
                "Rafael Maia",
                "JDK 21",
                "Spring Boot"


        );
    }
    public record Appinfo(
            String Application,
            String version,
            String developer,
            String JavaVersion,
            String framework
    ){}

}
