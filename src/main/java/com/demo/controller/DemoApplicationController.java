package com.demo.controller;


import com.demo.Model.Plans;
import com.demo.service.PlansService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Demo")
@RequiredArgsConstructor
@Slf4j
public class DemoApplicationController {

    private final PlansService plansService;

    @GetMapping(value = "/getPlans/{planType}")
    @ApiOperation(value = "Find the list of plans", response = List.class)
    public List<Plans> getPlans( @ApiParam(value = "Type of plan you need to get the " +
            "details for", required = true) @PathVariable(name = "planType") String planType){
        return plansService.getPlans(planType);
    }





}
