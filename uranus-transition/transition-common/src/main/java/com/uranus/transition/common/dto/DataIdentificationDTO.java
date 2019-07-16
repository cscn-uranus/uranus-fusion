package com.uranus.transition.common.dto;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/4/29 17:47
 */
@Data
public class DataIdentificationDTO {
  /** System Area Code */
  private String sac;

  /** System Identification Code */
  private String sic;

  /** Service Identification */
  private String si;
}
