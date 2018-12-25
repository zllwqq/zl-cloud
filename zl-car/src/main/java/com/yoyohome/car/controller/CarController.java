package com.yoyohome.car.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Value("${pay.url}")
    private String payUrl;

    @GetMapping("hi")
    public String home(@RequestParam(value = "name", defaultValue = "yoyo") String name) {
        return "hi " + name + " ,the pay url is:" + payUrl;
    }
}
