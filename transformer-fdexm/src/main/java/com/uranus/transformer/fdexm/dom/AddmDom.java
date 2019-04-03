package com.uranus.transformer.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmDom {

  @JsonProperty("TITLE")
  private String title;

  @JsonProperty("FILTIM")
  private String filtim;

  @JsonProperty("SOURCE")
  private String source;

  @JsonProperty("SOURCEMSGID")
  private String souremsgid;


  public String getTitle() {
    return title;
  }

  public String getFiltim() {
    return filtim;
  }

  public String getSource() {
    return source;
  }

  public String getSouremsgid() {
    return souremsgid;
  }
}
