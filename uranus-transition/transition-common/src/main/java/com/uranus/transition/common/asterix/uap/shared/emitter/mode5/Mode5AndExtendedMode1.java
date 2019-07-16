package com.uranus.transition.common.asterix.uap.shared.emitter.mode5;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode1.ExtendedMode1Code;
import lombok.Data;

/**
 * Mode5AndExtendedMode1
 *
 * <p>Data Item I062/110, Mode 5 Data reports & Extended Mode 1 Code
 *
 * <p>Definition : Mode 5 Data reports & Extended Mode 1 Code
 *
 * <p>Format : Compound Data Item, comprising a primary subfield of one octet, followed by the
 * indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
@Data
public class Mode5AndExtendedMode1 {

  /**
   * Structure of Primary Subfield:
   *
   * <p>bit-8 (SUM) Subfield #1: Mode 5 Summary = 0 Absence of Subfield #1 = 1 Presence of Subfield
   * #1
   *
   * <p>bit-7 (PMN) Subfield #2: Mode 5 PIN/ National Origin/Mission Code = 0 Absence of Subfield #
   * 2 = 1 Presence of Subfield #2
   *
   * <p>bit-6 (POS) Subfield #3: Mode 5 Reported Position = 0 Absence of Subfield #3 = 1 Presence of
   * Subfield #3
   *
   * <p>bit-5 (GA) Subfield #4: Mode 5 GNSS-derived Altitude = 0 Absence of Subfield #4 = 1 Presence
   * of Subfield #4
   *
   * <p>bit-4 (EM1) Subfield #5: Extended Mode 1 Code in Octal Representation = 0 Absence of
   * Subfield #5 = 1 Presence of Subfield #5
   *
   * <p>bit-3 (TOS) Subfield #6: Time Offset for POS and GA. = 0 Absence of Subfield #6 = 1 Presence
   * of Subfield #6
   *
   * <p>bit-2 (XP) Subfield #: X Pulse Presence. = 0 Absence of Subfield #7 = 1 Presence of Subfield
   * #7
   *
   * <p>bit-1 (FX) Extension Indicator = 0 no extension = 1 extension
   */
  private DataSpec dataSpec;

  /** Structure of Subfield #1: Mode 5 Summary: */
  private Mode5Summary mode5Summary;

  /** Structure of Subfield #2: Mode 5 PIN /National Origin/ Mission Code */
  private Mode5Identification mode5Identification;

  /** Structure of Subfield #3: Mode 5 Reported Position */
  private Mode5Position mode5Position;

  /** Structure of Subfield #4: Mode 5 GNSS-derived Altitude */
  private Mode5Altitude mode5Altitude;

  /** Structure of Subfield #5: Extended Mode 1 Code in Octal Representation */
  private ExtendedMode1Code extendedMode1Code;

  /** Structure of Subfield #6: Time Offset for POS and GA */
  private TimeOffset timeOffset;

  /** Structure of Subfield #7: X Pulse Presence */
  private XpulsePresenceStatus xpulsePresenceStatus;
}
