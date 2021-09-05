package com.sha.gestaoHoteleira.pages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sha.gestaoHoteleira.controller.ContactController;

@RestController
public class applicationTest {

    public static void main(String[] args) {
        SpringApplication.run(applicationTest.class, args);
    }

    @GetMapping("/hello")
    public void sayHello(@RequestParam(value = "myName", defaultValue = "Mundo") String name) {
        //return String.format("Olá, %s!", name);
    }
}
