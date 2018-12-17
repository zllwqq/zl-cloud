package com.yoyohome.ribbon.controller;

import com.yoyohome.ribbon.service.OrderRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRibbonController {

    @Autowired
    private OrderRibbonService orderRibbonService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        System.out.println("进入ribbon方法");
        return orderRibbonService.hello(name);
    }
}
