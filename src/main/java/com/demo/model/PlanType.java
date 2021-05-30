package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlanType {
  SIM_ONLY_PLANS("simo"),
  SIM_AND_PHONE_PLANS("phones");

  @Getter
  private final String planType;


}
