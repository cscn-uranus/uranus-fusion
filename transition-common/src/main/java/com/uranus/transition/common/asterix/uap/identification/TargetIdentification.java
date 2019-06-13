package com.uranus.transition.common.asterix.uap.identification;

import lombok.Data;

/**
 * TargetIdentification
 *
 * <p>Data Item I062/245, Target Identification
 *
 * Definition: Target (aircraft or vehicle)
 * identification in 8 characters.
 *
 * Format: Seven-octet fixed length Data Item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
@Data
public class TargetIdentification {

  /**
   * bits-56/55
   *
   * (STI)
   *
   * = 00 Callsign or registration downlinked from target
   *
   * = 01 Callsign not
   * downlinked from target
   *
   * = 10 Registration not downlinked from target
   *
   * = 11 Invalid
   */
  private TargetIdentificationEnum targetIdentificationEnum;

  /** bits-48/1
   *
   * Characters 1-8 (coded on 6 bits each) defining target identification */
  private String identification;
}
