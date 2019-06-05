package com.uranus.transition.common.asterix.uap.datainfo;

import com.uranus.transition.common.asterix.uap.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.asterix.uap.emitter.modec.LastModecCode;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.Measured3DHeight;
import com.uranus.transition.common.asterix.uap.measure.position.MeasuredPosition;
import lombok.Data;

/**
 * MeasuredInformation
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class MeasuredInformation {
  private SystemIdentification sensorIdentification;
  private MeasuredPosition measuredPosition;
  private Measured3DHeight measured3DHeight;
  private LastModecCode lastModecCode;
  private LastMode3Code lastMode3Code;
  private ReportType reportType;
}
