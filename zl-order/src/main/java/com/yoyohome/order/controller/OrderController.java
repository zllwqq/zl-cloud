package com.yoyohome.order.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("hi")
    public String home(@RequestParam(value = "name", defaultValue = "yoyo") String name) {
    	LocalDateTime now = null;
    	now.getDayOfMonth();
    	
        return "hi " + name + " ,i am from port:" + port;
    }

}
