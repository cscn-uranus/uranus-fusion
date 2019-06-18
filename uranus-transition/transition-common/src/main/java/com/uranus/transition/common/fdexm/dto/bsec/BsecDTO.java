package com.uranus.transition.common.fdexm.dto.bsec;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

/**
 * @author XiaoPeng
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BsecDTO {
  /**
   * FDEXM 报文类型。
   *
   * <p>'-' "TITLE" titleid
   *
   * <p>示例：-TITLE IFPL
   */
  @JsonProperty("TITLE")
  private String title;

  /**
   * 发报时间（时分秒）。
   *
   * <p>'-' "FILTIM" timehhmmss
   *
   * <p>示例：-FILTIM 080100
   */
  @JsonProperty("FILTIM")
  @JsonFormat(pattern = "HHmmss")
  private LocalTime sendingTime;

  /**
   * 机场代码。
   *
   * <p>'-' "AIRPORT"icaoaerodrome
   *
   * 示例：- AIRPORT ZBAA
   */
  @JsonProperty("AIRPORT")
  private String aerodrome;

  /**
   * 扇区列表。
   *
   * <p>'-' "BEGIN ""SECLIST" 1 { lps } '-' "END"" SECLIST"
   */
  @JsonProperty("SECLIST")
  private List<ControlSectorDTO> sectorDTOS;
}
