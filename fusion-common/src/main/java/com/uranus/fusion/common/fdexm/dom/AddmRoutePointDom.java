package com.uranus.fusion.common.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddmRoutePointDom {
  @JsonProperty("PTID")
  private String ptid;

  @JsonProperty("FL")
  private String fl;

  @JsonProperty("ETO")
  private String eto;

  @JsonProperty("ISPASS")
  private String ispass;

  public String getPtid() {
    return ptid;
  }

  public String getFl() {
    return fl;
  }

  public String getEto() {
    return eto;
  }

  public String getIspass() {
    return ispass;
  }
}
