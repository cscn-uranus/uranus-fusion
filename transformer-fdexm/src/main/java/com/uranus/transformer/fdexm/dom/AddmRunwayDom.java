package com.uranus.transformer.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmRunwayDom {
  @JsonProperty("RWYID")
  private String rwyid;

  @JsonProperty("RWYSTATUS")
  private String rwystatus;

  @JsonProperty("INFOR")
  private String infor;

  public String getRwyid() {
    return rwyid;
  }

  public String getRwystatus() {
    return rwystatus;
  }

  public String getInfor() {
    return infor;
  }
}
