package com.sj.firstAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sj")
public class CalculatorController {

    @GetMapping("/calculator/add/{var1}/{var2}")
    public String calculatorAdd (@PathVariable int var1, @PathVariable int var2) {
        int sum = var1+var2;
        String ans = "the sum is "+sum;
        return ans;

    }

    @GetMapping("/calculator/subtract/{var1}/{var2}")
    public String calculatorSubtract (@PathVariable int var1, @PathVariable int var2) {
        int sum = var1-var2;
        String ans = "the difference is "+sum;
        return ans;

    }

    @GetMapping("/calculator/multiply/{var1}/{var2}")
    public String calculatorMultiply (@PathVariable int var1, @PathVariable int var2) {
        float sum = var1*var2;
        String ans = "the product is "+sum;
        return ans;

    }

    @GetMapping("/calculator/divide/{var1}/{var2}")
    public String calculatorDivide (@PathVariable int var1, @PathVariable int var2) {
        if(var2!=0) {int sum = var1/var2;
            String ans = "the answer is "+ sum;
            return ans;
        }
        else return "cannot divide by zero!";
    }

}
