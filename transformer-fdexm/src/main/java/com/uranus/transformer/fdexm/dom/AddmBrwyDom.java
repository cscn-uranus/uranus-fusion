package com.uranus.transformer.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmBrwyDom {
  @JsonProperty("TITLE")
  private String title;

  @JsonProperty("FILTIM")
  private String filtim;

  @JsonProperty("AIRPORT")
  private String airport;

  @JsonProperty("RWYLIST")
  private Set<AddmRunwayDom> rwylist;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFiltim() {
    return filtim;
  }

  public void setFiltim(String filtim) {
    this.filtim = filtim;
  }

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public Set<AddmRunwayDom> getRwylist() {
    return rwylist;
  }

  public void setRwylist(Set<AddmRunwayDom> rwylist) {
    this.rwylist = rwylist;
  }
}
