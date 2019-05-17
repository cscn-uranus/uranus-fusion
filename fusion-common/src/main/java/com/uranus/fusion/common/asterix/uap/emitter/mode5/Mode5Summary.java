package com.uranus.fusion.common.asterix.uap.emitter.mode5;

import lombok.Data;

/**
 * Mode5Summary
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
@Data
public class Mode5Summary {

  private InterrogationStatusEnum mode5InterrogationStatusEnum;
  private DataReplyStatusEnum idDataReplyStatusEnum;
  private DataReplyStatusEnum mode5DataReplyStatusEnum;
  private DataReplyStatusEnum mode1DataReplyStatusEnum;
  private DataReplyStatusEnum mode2DataReplyStatusEnum;
  private DataReplyStatusEnum mode3DataReplyStatusEnum;
  private DataReplyStatusEnum modeCDataReplyStatusEnum;
  private DataReplyStatusEnum xpulseDataReplyStatusEnum;
}
