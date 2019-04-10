package com.uranus.fusion.asterix.aircraft.transponder.mode5;

/**
 * Mode5Summary
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5Summary {

  private InterrogationStatusEnum mode5InterrogationStatusEnum;
  private DataReplyStatusEnum idDataReplyStatusEnum;
  private DataReplyStatusEnum mode5DataReplyStatusEnum;
  private DataReplyStatusEnum mode1DataReplyStatusEnum;
  private DataReplyStatusEnum mode2DataReplyStatusEnum;
  private DataReplyStatusEnum mode3DataReplyStatusEnum;
  private DataReplyStatusEnum modeCDataReplyStatusEnum;
  private DataReplyStatusEnum xpulseDataReplyStatusEnum;

  public InterrogationStatusEnum getMode5InterrogationStatusEnum() {
    return mode5InterrogationStatusEnum;
  }

  public void setMode5InterrogationStatusEnum(
      InterrogationStatusEnum mode5InterrogationStatusEnum) {
    this.mode5InterrogationStatusEnum = mode5InterrogationStatusEnum;
  }

  public DataReplyStatusEnum getIdDataReplyStatusEnum() {
    return idDataReplyStatusEnum;
  }

  public void setIdDataReplyStatusEnum(DataReplyStatusEnum idDataReplyStatusEnum) {
    this.idDataReplyStatusEnum = idDataReplyStatusEnum;
  }

  public DataReplyStatusEnum getMode5DataReplyStatusEnum() {
    return mode5DataReplyStatusEnum;
  }

  public void setMode5DataReplyStatusEnum(DataReplyStatusEnum mode5DataReplyStatusEnum) {
    this.mode5DataReplyStatusEnum = mode5DataReplyStatusEnum;
  }

  public DataReplyStatusEnum getMode1DataReplyStatusEnum() {
    return mode1DataReplyStatusEnum;
  }

  public void setMode1DataReplyStatusEnum(
      DataReplyStatusEnum mode1DataReplyStatusEnum) {
    this.mode1DataReplyStatusEnum = mode1DataReplyStatusEnum;
  }

  public DataReplyStatusEnum getMode2DataReplyStatusEnum() {
    return mode2DataReplyStatusEnum;
  }

  public void setMode2DataReplyStatusEnum(
      DataReplyStatusEnum mode2DataReplyStatusEnum) {
    this.mode2DataReplyStatusEnum = mode2DataReplyStatusEnum;
  }

  public DataReplyStatusEnum getMode3DataReplyStatusEnum() {
    return mode3DataReplyStatusEnum;
  }

  public void setMode3DataReplyStatusEnum(
      DataReplyStatusEnum mode3DataReplyStatusEnum) {
    this.mode3DataReplyStatusEnum = mode3DataReplyStatusEnum;
  }

  public DataReplyStatusEnum getModeCDataReplyStatusEnum() {
    return modeCDataReplyStatusEnum;
  }

  public void setModeCDataReplyStatusEnum(
      DataReplyStatusEnum modeCDataReplyStatusEnum) {
    this.modeCDataReplyStatusEnum = modeCDataReplyStatusEnum;
  }

  public DataReplyStatusEnum getXpulseDataReplyStatusEnum() {
    return xpulseDataReplyStatusEnum;
  }

  public void setXpulseDataReplyStatusEnum(
      DataReplyStatusEnum xpulseDataReplyStatusEnum) {
    this.xpulseDataReplyStatusEnum = xpulseDataReplyStatusEnum;
  }
}
