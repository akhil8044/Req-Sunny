package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
  private Double net;
  private Double totalPrice;
  private Double totalGst;
  private Double cGst;
  private Double sGst;
}
