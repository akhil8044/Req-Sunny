package com.demo.dao;

import com.demo.Model.Benefits;
import com.demo.Model.Plans;
import com.demo.Model.Price;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class PlansDao {

    public List<Plans> getPlans(){
        return new ArrayList<>(

                Collections.singleton(new Plans("Vennela-500", "Unlimited plan", getPrice(555L),
                        new Benefits("1GB/Day", 1000L, 100, "Individual"), UUID.randomUUID()))
        );

    }


private Price getPrice(Long net){

        Long cGst = (net*9)/100;
        Long sGst = (net*9)/100;
        Long totalGst = sGst+cGst;
        Long totalPrice = net+totalGst;

        return new Price(net,totalPrice,totalGst,cGst,sGst);
}


}
