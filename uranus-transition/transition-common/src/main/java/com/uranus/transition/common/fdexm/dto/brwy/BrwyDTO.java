package com.uranus.transition.common.fdexm.dto.brwy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uranus.transition.common.fdexm.dto.brwy.RunwayDTO;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

/**
 * @author XiaoPeng
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrwyDTO {
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
   * 跑道列表，包含一条或多条 跑道号信息。
   *
   * <p>'-' "BEGIN ""RWYLIST" 1 { runway } '-' "END""RWYLIST "
   */
  @JsonProperty("RWYLIST")
  private List<RunwayDTO> runways;
}
