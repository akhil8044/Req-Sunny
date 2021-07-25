package com.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Benefits with the plan")
public class Benefits {

  private String data;
  private Long calls;
  private int messages;

  @ApiModelProperty(notes = "If mobile phone included")
  private boolean mInclude;


}
