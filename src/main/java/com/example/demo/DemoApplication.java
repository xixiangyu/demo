package com.example.demo;

import io.micrometer.core.annotation.Timed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController
class DemoController {
    @Timed(value = "main_page_request_duration", description = "Time taken to return main page", histogram = true)
    @GetMapping("/")
    public String hello() {
        LocalDateTime now = LocalDateTime.now();
        return "Hello World!" + now;
    }
}
