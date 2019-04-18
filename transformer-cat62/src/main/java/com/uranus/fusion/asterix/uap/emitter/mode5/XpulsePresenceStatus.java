package com.uranus.fusion.asterix.uap.emitter.mode5;

import lombok.Data;

/**
 * XpulsePresenceStatus
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
@Data
public class XpulsePresenceStatus {

  private DataReplyStatusEnum mode5Xpulse;
  private DataReplyStatusEnum modeCXpulse;
  private DataReplyStatusEnum mode3Xpulse;
  private DataReplyStatusEnum mode2Xpulse;
  private DataReplyStatusEnum mode1Xpulse;
}
