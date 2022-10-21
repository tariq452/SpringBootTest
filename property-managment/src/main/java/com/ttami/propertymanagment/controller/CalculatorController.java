package com.ttami.propertymanagment.controller;

import com.ttami.propertymanagment.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add (@RequestParam("num1") Double num1, @RequestParam("num1")Double num2){

        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double sub (@PathVariable("num1") Double num1, @PathVariable("num1")Double num2){

         Double result=null;
         if (num1>num2){
             result=num2-num1;
         }result=num1-num2;

        return result;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> multply(@RequestBody CalculatorDTO calculatorDTO){
        Double result =null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
