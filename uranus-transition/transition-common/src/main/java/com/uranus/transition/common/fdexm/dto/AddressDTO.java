package com.uranus.transition.common.fdexm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author XiaoPeng
 * @date 2019/06/04
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

  /**
   * 收报地址。
   *
   * <p>'-' "FAC" 1{ LIM_CHAR }30
   *
   * 示例：-FAC EGTTZGZP
   */
  @JsonProperty("FAC")
  private String aftnAddress;
}
