package com.uranus.transition.common.asterix.uap.emitter.mode5;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.emitter.mode1.ExtendedMode1Code;
import lombok.Data;

/**
 * Mode5AndExtendedMode1
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
@Data
public class Mode5AndExtendedMode1 {

  private DataSpec dataSpec;
  private Mode5Summary mode5Summary;
  private Mode5Identification mode5Identification;
  private Mode5Position mode5Position;
  private Mode5Altitude mode5Altitude;
  private ExtendedMode1Code extendedMode1Code;
  private TimeOffset timeOffset;
  private XpulsePresenceStatus xpulsePresenceStatus;
}
