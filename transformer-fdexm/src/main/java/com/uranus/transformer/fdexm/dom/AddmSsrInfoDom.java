package com.uranus.transformer.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmSsrInfoDom {
  @JsonProperty("TITLE")
  private String title;

  @JsonProperty("FILTIM")
  private String filtim;

  @JsonProperty("SSRCODE")
  private String ssrcode;

  @JsonProperty("SSROPER")
  private String ssroper;

  @JsonProperty("OPERTIME")
  private String opertime;

  @JsonProperty("ADEP")
  private String adep;

  @JsonProperty("ADES")
  private String ades;

  @JsonProperty("ARCID")
  private String arcid;

  @JsonProperty("IFPLID")
  private String ifplid;

  @JsonProperty("EOBD")
  private String eobd;

  @JsonProperty("EOBT")
  private String eobt;

  public String getTitle() {
    return title;
  }

  public String getFiltim() {
    return filtim;
  }

  public String getSsrcode() {
    return ssrcode;
  }

  public String getSsroper() {
    return ssroper;
  }

  public String getOpertime() {
    return opertime;
  }

  public String getAdep() {
    return adep;
  }

  public String getAdes() {
    return ades;
  }

  public String getArcid() {
    return arcid;
  }

  public String getIfplid() {
    return ifplid;
  }

  public String getEobd() {
    return eobd;
  }

  public String getEobt() {
    return eobt;
  }
}
