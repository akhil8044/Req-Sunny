package com.demo.controller;

import com.demo.model.PlanType;
import com.demo.service.PlansService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private PlansService plansService;

  @Test
  void getPlans() throws Exception {

    Mockito.when(plansService.getPlans(Mockito.any())).thenReturn(Collections.emptyList());
    HttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
            .get("/demo/getPlans?planType=simo")
            .accept(MediaType.APPLICATION_JSON)
            .content(toJson(getPlanTest()))
            .contentType(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
  }

  private PlanType getPlanTest() {
    return PlanType.SIMO;
  }

  private String toJson(Object object) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }
}