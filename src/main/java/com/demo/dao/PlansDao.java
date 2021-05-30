package com.demo.dao;

import com.demo.model.Benefits;
import com.demo.model.Plans;
import com.demo.model.Price;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PlansDao {

  public List<Plans> getPlans() {
    return List.of(new Plans("Vennela-500", "Unlimited plan", getPrice(555D),
        new Benefits("1GB/Day", 1000L, 100, "Individual"), UUID.randomUUID()));

  }

  private Price getPrice(final Double net) {
    Double cGst = (net * 9) / 100;
    Double sGst = (net * 9) / 100;
    Double totalGst = sGst + cGst;
    Double totalPrice = net + totalGst;
    return new Price(net, totalPrice, totalGst, cGst, sGst);
  }


}
