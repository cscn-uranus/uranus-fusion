package com.uranus.transition.common.fdexm.dto.ifpl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uranus.transition.common.fdexm.dto.PositiveEnum;
import lombok.Data;

import java.time.LocalDateTime;

/** @author XiaoPeng */
@Data
public class RoutePointDTO {

  /**
   * 航路点标识
   *
   * <p>'-' "PTID" point
   *
   * <p>示例：-PTID EGLL
   */
  @JsonProperty("PTID")
  private String pointId;

  /**
   * 高度层数据。
   *
   * <p>'-' " FL" flightlevel
   *
   * <p>示例：-FL F107
   */
  @JsonProperty("FL")
  private String flightLevel;

  /**
   * 预计经过航路点的日期 与时间
   *
   * <p>'-' "ETO" date ! timehhmm ! seconds
   *
   * <p>示例：-ETO 20130106120915
   */
  @JsonProperty("ETO")
  @JsonFormat(pattern = "yyyyMMddHHmmss")
  private LocalDateTime estimatedTimeOver;

  /**
   * 是否已经通过该航路点 （N 未通过，Y 已经通 过）。
   *
   * <p>'-' "ISPASS" ('N'|'Y')
   *
   * <p>示例：-ISPASS Y
   */
  @JsonProperty("ISPASS")
  private PositiveEnum passStatus;
}
