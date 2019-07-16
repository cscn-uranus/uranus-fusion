package com.uranus.transition.common.asterix.uap.shared.track;

import lombok.Data;

/**
 * ComposedTrackNumber
 *
 * <p>Data Item I062/510, Composed Track Number
 *
 * Definition : Identification of a system track
 *
 *
 * Structure: Extendible data item, comprising a first part of three octets (Master Track Number),
 * followed by three-octet extents (Slave Tracks Numbers).
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
@Data
public class ComposedTrackNumber {

  /** bits 24/17 (SYSTEM UNIT IDENTIFICATION) */
  private String systemUnitIdentification;

  /**
   * bits 16/2 (SYSTEM TRACK NUMBER)
   */
  private String systemTrackNumber;
}
