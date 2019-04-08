package com.uranus.fusion.common.asterix.aircraft.transponder.mode5;

/**
 * XpulsePresenceStatus
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class XpulsePresenceStatus {

  private DataReplyStatusEnum mode5Xpulse;
  private DataReplyStatusEnum modeCXpulse;
  private DataReplyStatusEnum mode3Xpulse;
  private DataReplyStatusEnum mode2Xpulse;
  private DataReplyStatusEnum mode1Xpulse;

  public DataReplyStatusEnum getMode5Xpulse() {
    return mode5Xpulse;
  }

  public void setMode5Xpulse(DataReplyStatusEnum mode5Xpulse) {
    this.mode5Xpulse = mode5Xpulse;
  }

  public DataReplyStatusEnum getModeCXpulse() {
    return modeCXpulse;
  }

  public void setModeCXpulse(DataReplyStatusEnum modeCXpulse) {
    this.modeCXpulse = modeCXpulse;
  }

  public DataReplyStatusEnum getMode3Xpulse() {
    return mode3Xpulse;
  }

  public void setMode3Xpulse(DataReplyStatusEnum mode3Xpulse) {
    this.mode3Xpulse = mode3Xpulse;
  }

  public DataReplyStatusEnum getMode2Xpulse() {
    return mode2Xpulse;
  }

  public void setMode2Xpulse(DataReplyStatusEnum mode2Xpulse) {
    this.mode2Xpulse = mode2Xpulse;
  }

  public DataReplyStatusEnum getMode1Xpulse() {
    return mode1Xpulse;
  }

  public void setMode1Xpulse(DataReplyStatusEnum mode1Xpulse) {
    this.mode1Xpulse = mode1Xpulse;
  }
}
