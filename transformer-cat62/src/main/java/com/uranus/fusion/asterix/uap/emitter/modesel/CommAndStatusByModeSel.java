package com.uranus.fusion.asterix.uap.emitter.modesel;

import com.uranus.fusion.asterix.uap.comm.CommCapabilityEnum;
import com.uranus.fusion.asterix.uap.datainfo.CapabilityEnum;
import com.uranus.fusion.asterix.uap.measure.altitude.AltitudeReportCapabilityEnum;
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
