package com.ttami.propertymanagment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public Double add (Double num1,Double num2){

        return num1+num2;
    }
}
