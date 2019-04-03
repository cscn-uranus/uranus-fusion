package com.uranus.fusion.transformer.asterix.aircraft.transponder.modeselective;

import java.util.Objects;

/**
 * ModeSelMb
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class ModeSelMb {

  private String bdsReport;
  private String bdsRegister;
  private String bdsCode;

  public String getBdsReport() {
    return bdsReport;
  }

  public void setBdsReport(String bdsReport) {
    this.bdsReport = bdsReport;
  }

  public String getBdsRegister() {
    return bdsRegister;
  }

  public void setBdsRegister(String bdsRegister) {
    this.bdsRegister = bdsRegister;
  }

  public String getBdsCode() {
    return bdsCode;
  }

  public void setBdsCode(String bdsCode) {
    this.bdsCode = bdsCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ModeSelMb)) {
      return false;
    }
    ModeSelMb modesMb = (ModeSelMb) o;
    return Objects.equals(bdsReport, modesMb.bdsReport) &&
        Objects.equals(bdsRegister, modesMb.bdsRegister) &&
        Objects.equals(bdsCode, modesMb.bdsCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bdsReport, bdsRegister, bdsCode);
  }
}
