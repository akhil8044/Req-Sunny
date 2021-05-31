package com.demo.service;

import  com.demo.dao.PlansDao;
import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.PlanExceptions;
import com.demo.model.PlanType;
import com.demo.model.Plans;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlansService {

  private final PlansDao plansDao;

  public List<Plans> getPlans(PlanType planType) {
    switch (planType) {
      case SIMO:
        return plansDao.getPlans();
      case PHONE:
      default:
        throw new PlanExceptions(ErrorMessage.WRONG_PLANTYPE.getMessage());

    }
  }
}
