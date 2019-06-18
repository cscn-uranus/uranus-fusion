package com.uranus.transition.common.fdexm.dto.brwy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** @author XiaoPeng */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunwayDTO {
  /**
   * 跑道号。
   *
   * <p>'-' "RWYID"runwaycode
   *
   * <p>示例：- RWYID 02L
   */
  @JsonProperty("RWYID")
  private String runwayId;

  /**
   * 跑道状态，定义四种跑道 状态，分别用以下大写字符串表示：
   *
   * <p>1.CLS――关闭跑道； 2.ARR――仅进港； 3.DEP――仅离港； 4.ALL――既进港又离港。
   *
   * <p>'-' "RWYSTATUS" 3{ALPHA}3
   *
   * <p>示例：- RWYSTATUS CLS
   */
  @JsonProperty("RWYSTATUS")
  private RunwayStatusEnum status;

  /**
   * 与跑道相关的说明。
   *
   * <p>'-' "INFOR"text20
   *
   * <p>示例：- INFOR runway repair
   */
  @JsonProperty("INFOR")
  private String info;
}
