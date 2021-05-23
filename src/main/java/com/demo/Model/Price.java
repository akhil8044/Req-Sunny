package com.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
    Long totalPrice, totalGst, cGst,sGst;
}
