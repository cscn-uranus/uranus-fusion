package com.uranus.fusion.common.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmControlSectorDom {

  @JsonProperty("SECTORID")
  private String sectorid;

  @JsonProperty("SECTORS")
  private String sectors;

  public String getSectorid() {
    return sectorid;
  }

  public String getSectors() {
    return sectors;
  }
}
