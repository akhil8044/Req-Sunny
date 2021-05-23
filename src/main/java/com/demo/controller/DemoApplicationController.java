package com.demo.controller;


import com.demo.Model.Plans;
import com.demo.service.PlansService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoApplicationController {

    //Updated

    private final PlansService plansService;

    @GetMapping(value = "/Demo/getPlans/{planType}")
    public List<Plans> getPlans(@PathVariable(name = "planType") String planType){
        return plansService.getPlans(planType);
    }





}
