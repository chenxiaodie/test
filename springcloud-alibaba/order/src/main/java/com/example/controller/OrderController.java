package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    public String add(){
        System.out.println("下单成功");
        return "Hello World!";
    }








   

}
