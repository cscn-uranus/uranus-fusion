package com.uranus.transition.common.asterix.uap.identification;

import lombok.Data;

/**
 * SystemIdentification
 *
 * <ul>
 *   <li>Data Item I062/010, Data Source Identifier
 *       <p>Definition : Identification of the system sending the data
 *       <p>Format : Two-octet fixed length Data Item
 *       <p>The up-to-date list of SACs is published on the EUROCONTROL Web Site
 *       (http://www.eurocontrol.int/asterix).
 *   <li>Data Item I062/390, Flight Plan Related Data
 *       <p>Structure of Subfield # 1:
 *       <p>FPPS Identification Tag
 *   <li>Data Item I062/340, Measured Information
 *       <p>Structure of Subfield # 1:
 *       <p>Sensor Identification
 * </ul>
 *
 * @author 肖鹏 tellxp@github.com
 */
@Data
public class SystemIdentification {

  /**
   * bits-16/9
   *
   * <p>(SAC)
   *
   * <p>System Area Code
   */
  private String sac;

  /**
   * bits 8/1
   *
   * <p>(SIC)
   *
   * <p>System Identification Code
   */
  private String sic;
}
