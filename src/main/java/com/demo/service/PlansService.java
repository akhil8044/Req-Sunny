package com.demo.service;

import com.demo.Model.PlanType;
import com.demo.Model.Plans;
import com.demo.dao.PlansDao;
import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.PlanExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlansService {

    private final PlansDao plansDao;


    public List<Plans> getPlans(String planType) {

        if (!(planType.equalsIgnoreCase(PlanType.SIM_ONLY_PLANS.getPlanType())
                || planType.equalsIgnoreCase(PlanType.SIM_AND_PHONE_PLANS.getPlanType())))
        {
            throw new PlanExceptions(ErrorMessage.WRONG_PLANTYPE.getMessage());
        }

        if (PlanType.SIM_ONLY_PLANS.getPlanType().equalsIgnoreCase(planType))
        {
            return plansDao.getPlans();
        } else
            return null;


    }
}
