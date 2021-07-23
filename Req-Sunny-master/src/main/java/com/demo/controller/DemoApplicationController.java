package com.demo.controller;

import com.demo.model.PlanType;
import com.demo.model.Plans;
import com.demo.service.PlansService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

        log.info("Plan type {} selected", planType);
        return plansService.getPlans(planType);
    }

    @PostMapping(value = "/demo/createIndex/{indexName}")
    public void createIndex(@PathVariable String indexName) throws IOException {
        plansService.createIndex(indexName);
    }

    @PostMapping(value = "demo/addEntry/{indexName}")
    public void addEntry(@RequestBody Plans plans, @PathVariable String indexName) throws IOException {
        plansService.addEntry(plans,indexName);
    }
}
