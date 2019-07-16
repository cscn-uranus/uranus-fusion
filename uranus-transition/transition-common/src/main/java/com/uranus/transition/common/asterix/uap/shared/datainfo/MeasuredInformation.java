package com.uranus.transition.common.asterix.uap.shared.datainfo;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.modec.ModecCode;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.Measured3dHeight;
import com.uranus.transition.common.asterix.uap.shared.measure.position.MeasuredPosition;
import lombok.Data;

/**
 * MeasuredInformation
 *
 * <p>Data Item I062/340, Measured Information
 *
 * Definition : All measured data related to the last
 * report used to update the track.
 *
 * Format : Compound Data Item, comprising a primary subfield of
 * one octet, followed by the indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class MeasuredInformation {

  /**
   * Structure of Primary Subfield:
   *
   * <p>bit-8 (SID) Subfield #1: Sensor Identification = 0 Absence of Subfield #1 = 1 Presence of
   * Subfield #1
   *
   * bit-7 (POS) Subfield #2: Measured Position = 0 Absence of Subfield #2 = 1 Presence
   * of Subfield #2
   *
   * bit-6 (HEI) Subfield #3: Measured 3-D Height = 0 Absence of Subfield #3 = 1
   * Presence of Subfield #3
   *
   * bit-5 (MDC) Subfield #4: Last Measured Mode C code = 0 Absence of
   * Subfield #4 = 1 Presence of Subfield #4
   *
   * bit-4 (MDA) Subfield #5: Last Measured Mode 3/A code =
   * 0 Absence of Subfield #5 = 1 Presence of Subfield #5
   *
   * bit-3 (TYP) Subfield #6: Report Type = 0
   * Absence of Subfield #6 = 1 Presence of Subfield #6
   *
   * bit-2 (spare) Spare
   *
   * bit set to zero
   *
   * bit-1 FX
   * Extension indicator = 0 no extension = 1 extension
   */
  private DataSpec dataSpec;

  /** Structure of Subfield # 1: Sensor Identification */
  private SystemIdentification sensorIdentification;

  /** Structure of Subfield # 2: Measured Positio */
  private MeasuredPosition measuredPosition;

  /** Structure of Subfield # 3: Measured 3-D Height */
  private Measured3dHeight measured3dHeight;

  /** Structure of Subfield # 4: Last Measured Mode C Code */
  private ModecCode modecCode;

  /** Structure of Subfield # 5: Last Measured Mode 3/A Code */
  private LastMode3Code lastMode3Code;

  /** Structure of Subfield # 6: Report Type */
  private ReportType reportType;
}
