package com.uranus.transition.common.asterix.uap.shared.identification;

import lombok.Data;

/**
 * ServiceIdentification
 *
 * <p>Data Item I062/015, Service Identification
 *
 * <p>Definition : Identification of the service provided to one or more users.
 *
 * <p>Format : One-Octet fixed length data item.
 *
 * @author tellxp@github.com
 * @date 2018/11/16
 */
@Data
public class ServiceIdentification  {

  /**
   * bits8/1
   *
   * <p>Service Identification
   */
  private String identification;
}
