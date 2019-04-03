package com.uranus.transformer.fdexm.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddmIfplDom {

  @JsonProperty("TITLE")
  private String title;

  @JsonProperty("FILTIM")
  private String filtim;

  @JsonProperty("IFPLID")
  private String ifplid;

  @JsonProperty("SOURCE")
  private String source;

  @JsonProperty("ADEP")
  private String adep;

  @JsonProperty("ADES")
  private String ades;

  @JsonProperty("ARCID")
  private String arcid;

  @JsonProperty("EOBD")
  private String eobd;

  @JsonProperty("EOBT")
  private String eobt;

  @JsonProperty("SOURCEMSGID")
  private String sourcemsgid;

  @JsonProperty("ETA")
  private String eta;

  @JsonProperty("ROUTE")
  private String route;

  @JsonProperty("FPCTST")
  private String fpctst;

  @JsonProperty("ADESOLD")
  private String adesold;

  @JsonProperty("ALTRNT1")
  private String altrnt1;

  @JsonProperty("ALTRNT2")
  private String altrnt2;

  @JsonProperty("SSRCODE")
  private String ssrcode;

  @JsonProperty("FLTRUL")
  private String fltrul;

  @JsonProperty("FLTTYP")
  private String flttyp;

  @JsonProperty("RMK")
  private String rmk;

  @JsonProperty("ADD")
  private String add;

  @JsonProperty("ATD")
  private String atd;

  @JsonProperty("ADA")
  private String ada;

  @JsonProperty("ATA")
  private String ata;

  @JsonProperty("TTLEET")
  private String ttleet;

  @JsonProperty("ARCTYP")
  private String arctyp;

  @JsonProperty("WKTRC")
  private String wktrc;

  @JsonProperty("REG")
  private String reg;

  @JsonProperty("CEQPT")
  private String ceqpt;

  @JsonProperty("SEQPT")
  private String seqpt;

  @JsonProperty("NAV")
  private String nav;

  @JsonProperty("PBN")
  private String pbn;

  @JsonProperty("DAT")
  private String dat;

  @JsonProperty("SEL")
  private String sel;

  @JsonProperty("OPR")
  private String opr;

  @JsonProperty("PER")
  private String per;

  @JsonProperty("RFL")
  private String rfl;

  @JsonProperty("CFL")
  private String cfl;

  @JsonProperty("XFL")
  private String xfl;

  @JsonProperty("SPEED")
  private String speed;

  @JsonProperty("SECTOR")
  private String sector;

  @JsonProperty("TXT")
  private String txt;

  @JsonProperty("DOF")
  private String dof;

  @JsonProperty("TEAM")
  private String team;

  @JsonProperty("TASK")
  private String task;

  @JsonProperty("ISCOUPLE")
  private String iscouple;

  @JsonProperty("ADDR")
  private List<AddmAddressDom> addr;

  @JsonProperty("RTEPTS")
  private List<AddmRoutePointDom> rtepts;

  public String getTitle() {
    return title;
  }

  public String getFiltim() {
    return filtim;
  }

  public String getIfplid() {
    return ifplid;
  }

  public String getSource() {
    return source;
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

  public String getEobd() {
    return eobd;
  }

  public String getEobt() {
    return eobt;
  }

  public String getSourcemsgid() {
    return sourcemsgid;
  }

  public String getEta() {
    return eta;
  }

  public String getRoute() {
    return route;
  }

  public String getFpctst() {
    return fpctst;
  }

  public String getAdesold() {
    return adesold;
  }

  public String getAltrnt1() {
    return altrnt1;
  }

  public String getAltrnt2() {
    return altrnt2;
  }

  public String getSsrcode() {
    return ssrcode;
  }

  public String getFltrul() {
    return fltrul;
  }

  public String getFlttyp() {
    return flttyp;
  }

  public String getRmk() {
    return rmk;
  }

  public String getAdd() {
    return add;
  }

  public String getAtd() {
    return atd;
  }

  public String getAda() {
    return ada;
  }

  public String getAta() {
    return ata;
  }

  public String getTtleet() {
    return ttleet;
  }

  public String getArctyp() {
    return arctyp;
  }

  public String getWktrc() {
    return wktrc;
  }

  public String getReg() {
    return reg;
  }

  public String getCeqpt() {
    return ceqpt;
  }

  public String getSeqpt() {
    return seqpt;
  }

  public String getNav() {
    return nav;
  }

  public String getPbn() {
    return pbn;
  }

  public String getDat() {
    return dat;
  }

  public String getSel() {
    return sel;
  }

  public String getOpr() {
    return opr;
  }

  public String getPer() {
    return per;
  }

  public String getRfl() {
    return rfl;
  }

  public String getCfl() {
    return cfl;
  }

  public String getXfl() {
    return xfl;
  }

  public String getSpeed() {
    return speed;
  }

  public String getSector() {
    return sector;
  }

  public String getTxt() {
    return txt;
  }

  public String getDof() {
    return dof;
  }

  public String getTeam() {
    return team;
  }

  public String getTask() {
    return task;
  }

  public String getIscouple() {
    return iscouple;
  }

  public List<AddmAddressDom> getAddr() {
    return addr;
  }

  public List<AddmRoutePointDom> getRtepts() {
    return rtepts;
  }

}
