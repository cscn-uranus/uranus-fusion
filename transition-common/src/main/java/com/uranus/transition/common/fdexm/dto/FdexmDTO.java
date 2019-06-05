package com.uranus.transition.common.fdexm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalTime;

/**
 * @author XiaoPeng
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdexmDTO {

  /**
   * FDEXM报文类型
   *
   * <p>语法： '-' "TITLE" titleid
   *
   * <p>示例： -TITLE IFPL
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页82行
   */
  @JsonProperty(value = "TITLE")
  private String title;

  /**
   * 发报时间（时分秒）
   *
   * <p>语法： '-' "FILTIM" timehhmmss
   *
   * <p>示例： -FILTIM 080100
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页38行
   */
  @JsonProperty(value = "FILTIM")
  @JsonFormat(pattern = "HHmmss")
  private LocalTime sendingTime;

  /**
   * 报文源的系统标识
   *
   * <p>语法： '-' "SOURCE" string
   *
   * <p>示例： -SOURCE CDATC_AIRNET_ZUUU
   */
  @JsonProperty(value = "SOURCE")
  private String source;

  /**
   * 报文源的系统标识的ID
   *
   * <p>语法： '-' "SOURCEMSGID" number
   *
   * <p>示例： -SOURCEMSGID 139942324
   */
  @JsonProperty(value = "SOURCEMSGID")
  private String sourceMessageId;

  /**
   * 报文 JSON 字符串
   *
   * 由于在一开始 Fdexm 进入时，需要判断不同类型的 Fdexm，因此一开始 Fdexm 只映射基础字段
   *
   * 在判断为不同的报文类型后，再进行详细字段的映射，该字段就是为了下一步详细映射提供使用的
   */
  private String text;
}
