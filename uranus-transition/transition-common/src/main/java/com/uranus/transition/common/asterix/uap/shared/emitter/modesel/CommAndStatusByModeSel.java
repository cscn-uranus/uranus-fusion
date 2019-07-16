package com.uranus.transition.common.asterix.uap.shared.emitter.modesel;

import com.uranus.transition.common.asterix.uap.shared.comm.CommCapabilityEnum;
import com.uranus.transition.common.asterix.uap.shared.datainfo.CapabilityEnum;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.AltitudeReportCapabilityEnum;
import lombok.Data;

/**
 * CommAndStatusByModeSel
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/22
 */
@Data
public class CommAndStatusByModeSel {

  private CommCapabilityEnum commCapabilityEnum;
  private ModeSelFlightStatusEnum modeSelFlightStatusEnum;
  private CapabilityEnum specificServiceCapability;
  private AltitudeReportCapabilityEnum altitudeReportCapabilityEnum;
  private CapabilityEnum aircraftIdentificationCapability;

  private String bdsA;
  private String bdsB;
}
