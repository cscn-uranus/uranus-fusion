package com.uranus.transition.common.fdexm.dto.bsec;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author XiaoPeng
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ControlSectorDTO {

  /**
   * 席位代码。
   *
   * <p>'-' "SECTORID" lpscode
   *
   * 示例：- SECTORID ACC02
   */
  @JsonProperty("SECTORID")
  private String logicalSectorId;

  /**
   * 扇区代码（一个或多个扇 区，两者之间用SPACE分 隔）。
   *
   * <p>'-' "SECTORS" sectorcode
   *
   * 示例：- SECTORS AC02 AC03 AC01
   */
  @JsonProperty("SECTORS")
  private String physicalSectorIds;
}
