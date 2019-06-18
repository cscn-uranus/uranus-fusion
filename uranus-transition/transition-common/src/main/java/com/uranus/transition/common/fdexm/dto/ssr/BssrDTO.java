package com.uranus.transition.common.fdexm.dto.ssr;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** @author XiaoPeng */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BssrDTO {
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
   * 应答机模式和编码 *
   *
   * <p>'-' "SSRCODE" 'A' ! 4{ '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' }4
   *
   * <p>示例：-SSRCODE A3312
   */
  @JsonProperty("SSRCODE")
  private String ssrCode;

  /**
   * 分配或者回收该应答机， DST表示分配信息，REC表示 回收信息。
   *
   * <p>'-'"SSROPER" ('DST'|'REC')
   *
   * <p>示例：-SSROPER DST
   */
  @JsonProperty("SSROPER")
  private SsrOperationEnum operation;

  /**
   * 分配或回收时间，当FLAG 值为DST时OPERTIME表示分 配时间，当FLAG值为REC时 OPERTIME表示回收时间。
   *
   * <p>'-' "OPERTIME" datetime
   *
   * <p>示例：- OPERTIME 201301020800
   */
  @JsonProperty("OPERTIME")
  @JsonFormat(pattern = "yyyyMMddHHmm")
  private LocalDateTime operationTime;

  /**
   * 起飞机场代码、‘AFIL’或 ‘ZZZZ’，与该应答机关联 的飞行计划起飞机场代码。
   *
   * <p>'-' "ADEP" (icaoaerodrome | 'AFIL' | 'ZZZZ')
   *
   * <p>示例：-ADEP ZBAA -ADEP AFIL
   */
  @JsonProperty("ADEP")
  private String actualDepartureAerodrome;

  /**
   * 降落机场代码或"ZZZZ"（如降落机场 无ICAO 规定的代码时使用）
   *
   * <p>'-' "ADES" (icaoaerodrome | "ZZZZ")
   *
   * <p>示例：-ADES ZBAA -ADES ZZZZ
   */
  @JsonProperty("ADES")
  private String actualDestinationAerodrome;

  /**
   * 航空器标识（航空器注册码或航班 号）。
   *
   * <p>'-' "ARCID" aircraftid
   *
   * <p>示例：-ARCID CCA4101 -ARCID B2839
   */
  @JsonProperty("ARCID")
  private String flightIdentification;

  /**
   * 飞行计划ID
   *
   * <p>'-' "IFPLID" text20
   *
   * <p>示例：-IFPLID 2013110001
   */
  @JsonProperty("IFPLID")
  private String ifplId;

  /**
   * 预计撤轮档日期
   *
   * <p>'-' "EOBD" date
   *
   * <p>示例：-EOBD 20130612
   */
  @JsonProperty("EOBD")
  @JsonFormat(pattern = "yyyyMMdd")
  private LocalDate estimatedOffBlockDate;

  /**
   * 预计撤轮档时间
   *
   * <p>'-' "EOBT" timehhmm
   *
   * <p>示例：-EOBT 2212
   */
  @JsonProperty("EOBT")
  @JsonFormat(pattern = "HHmm")
  private LocalTime estimatedOffBlockTime;
}
