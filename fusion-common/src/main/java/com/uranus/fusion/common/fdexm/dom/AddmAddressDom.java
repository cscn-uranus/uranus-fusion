package com.uranus.fusion.common.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmAddressDom {

  @JsonProperty("FAC")
  private String fac;

  public String getFac() {
    return fac;
  }
}
