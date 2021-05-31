package com.demo.controller;

import com.demo.model.PlanType;
import com.demo.model.Plans;
import com.demo.service.PlansService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class DemoApplicationController {

  private final PlansService plansService;


  @GetMapping(value = "/demo/getPlans")
  @ApiOperation(value = "Find the list of plans", response = List.class)
  public List<Plans> getPlans(@ApiParam(value = "Type of plan you need to get the " +
          "details for", required = true) @RequestParam(name = "planType") PlanType planType) {
    System.out.println(planType);

    log.info("Plan type {} selected", planType);
    return plansService.getPlans(planType);

  }


}
