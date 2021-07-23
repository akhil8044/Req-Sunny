package com.demo.dao;

import com.demo.model.Plans;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlansDao {

  public List<Plans> getPlans() {

    return new ArrayList<>();
  }



}
