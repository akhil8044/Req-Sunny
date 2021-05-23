package com.demo.service;

import com.demo.Model.Plans;
import com.demo.dao.PlansDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlansService {

    private final PlansDao plansDao;

    public List<Plans> getPlans(String planType) {
        if (planType.equalsIgnoreCase("simo"))
            return plansDao.getPlans();
        else
            return null;

    }
}