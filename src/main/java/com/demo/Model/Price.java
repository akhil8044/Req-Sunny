package com.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
    Long net,totalPrice, totalGst, cGst,sGst;
}
