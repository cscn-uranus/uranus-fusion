package com.uranus.fusion.common.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmTimeDom {

  @JsonProperty("BTIME")
  private String btime;

  @JsonProperty("ETIME")
  private String etime;

  public String getBtime() {
    return btime;
  }

  public String getEtime() {
    return etime;
  }
}
