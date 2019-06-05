package com.uranus.transition.common.fdexm.dto.ifpl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uranus.transition.common.fdexm.dto.PositiveEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * IfplDTO
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IfplDTO {

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
   * 飞行计划 ID
   *
   * <p>语法： '-' "IFPLID" text20
   *
   * <p>示例： -IFPLID 2013110001
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页43行
   */
  @JsonProperty(value = "IFPLID")
  private String ifplId;

  /**
   * 航路点列表（可以包括机场代码），按飞行轨迹先后顺序排列。
   *
   * <p>语法： '-' "BEGIN""RTEPTS" 1{pt} '-' "END""RTEPTS"
   *
   * <p>示例： -BEGIN RTEPTS -PT -PTID EGLL -FL F000 -ETO 20130106115100-ISPASS Y -PT -PTID BPK -FL
   * F060 -ETO 20130106120240-ISPASS N -PT -PTID TOTRI -FL F107 -ETO 20130106120600-ISPASS N -END
   * RTEPTS
   *
   * <p>详见国标“MH/T 4029.3-2015” 第18页64行
   */
  @JsonProperty(value = "RTEPTS")
  private List<RoutePointDTO> routePointDTOS;

  /**
   * 航空器标识(航空器注册码或航班号)
   *
   * <p>语法： '-' "ARCID" aircraftid
   *
   * <p>示例： -ARCID CCA4101 -ARCID B2839
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页14行
   */
  @JsonProperty(value = "ARCID")
  private String flightIdentification;

  /**
   * 起飞机场代码、‘AFIL’或‘ZZZZ’
   *
   * <p>语法： '-' "ADEP" (icaoaerodrome | 'AFIL' | 'ZZZZ')
   *
   * <p>示例： -ADEP ZBAA -ADEP AFIL
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页7行
   */
  @JsonProperty(value = "ADEP")
  private String actualDepartureAerodrome;

  /**
   * 降落机场代码或"ZZZZ"（如降落机场无 ICAO 规定的代码时使用)
   *
   * <p>语法： '-' "ADES" (icaoaerodrome | 'ZZZZ')
   *
   * <p>示例： -ADES ZBAA -ADES ZZZZ
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页8行
   */
  @JsonProperty(value = "ADES")
  private String actualDestinationAerodrome;

  /**
   * 预计撤轮档日期
   *
   * <p>语法： '-' "EOBD" date
   *
   * <p>示例： -EOBD 20130612
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页32行
   */
  @JsonProperty(value = "EOBD")
  @JsonFormat(pattern = "yyyyMMdd")
  private LocalDate estimatedOffBlockDate;

  /**
   * 预计撤轮档时间
   *
   * <p>语法： '-' "EOBT" time HHmm
   *
   * <p>示例： -EOBD 20130612
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页35行
   */
  @JsonProperty(value = "EOBT")
  @JsonFormat(pattern = "HHmm")
  private LocalTime estimatedOffBlockTime;

  /**
   * 预计落地的日期与时间
   *
   * <p>语法： '-' "ETA" date ! timehhmm ! seconds
   *
   * <p>示例： -ETA 20130106120815
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页36行
   */
  @JsonProperty(value = "ETA")
  @JsonFormat(pattern = "yyyyMMddHHmmss")
  private LocalDateTime estimatedTimeOfArrival;

  /**
   * 航路数据（数据格式与 AFTN 中编组15 相同)
   *
   * <p>语法： '-' "ROUTE" {LIM_CHAR}
   *
   * <p>示例：-ROUTE N0402F270 BPK UM185 CLN UL620 REDFA/N0390F230
   *
   * <p>详见国标“MH/T 4029.3-2015” 第17页63行
   */
  @JsonProperty(value = "ROUTE")
  private String routeTrajectory;

  /**
   * 飞行计划状态
   *
   * <p>语法： '-' "FPCTST" planstatus
   *
   * <p>示例： - FPCTST ACT
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页37行
   */
  @JsonProperty(value = "FPCTST")
  private String flightPlanCurrentStatus;

  /**
   * 原降落机场代码（相对于当前的原落地机场）、"AFIL"或"ZZZZ"
   *
   * <p>语法： '-' "ADESOLD" (icaoaerodrome | "ZZZZ")
   *
   * <p>示例： -ADESOLD ZBAA -ADESOLD ZZZZ
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页9行
   */
  @JsonProperty(value = "ADESOLD")
  private String originalActualDestinationAerodrome;

  /**
   * 第一备降机场代码，如机场无 ICAO 定义的代码，则填入"ZZZZ"
   *
   * <p>语法： '-' "ALTRNT1" (icaoaerodrome | "ZZZZ")
   *
   * <p>示例： -ALTRNT1 ZUGY
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页11行
   */
  @JsonProperty(value = "ALTRNT1")
  private String alternateAerodrome1;

  /**
   * 第二备降机场代码，如机场无 ICAO 定义的代码，则填入"ZZZZ"
   *
   * <p>语法： '-' "ALTRNT2" (icaoaerodrome | "ZZZZ")
   *
   * <p>示例： -ALTRNT2 ZSPD
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页12行
   */
  @JsonProperty(value = "ALTRNT2")
  private String alternateAerodrome2;

  /**
   * 应答机模式和编码
   *
   * <p>语法： '-' "SSRCODE" 'A' ! 4{ '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' }4
   *
   * <p>示例： -SSRCODE A3312
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页82行
   */
  @JsonProperty(value = "SSRCODE")
  private String ssrCode;

  /**
   * 飞行规则（同 AFTN 编组 8 中数据项A）
   *
   * <p>语法： '-' "FLTRUL" flightrule
   *
   * <p>示例： -FLTRUL I
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页39行
   */
  @JsonProperty(value = "FLTRUL")
  private String flightRule;

  /**
   * 飞行种类（同 AFTN 编组 8 中数据项B）
   *
   * <p>语法： '-' "FLTRUL" flighttype
   *
   * <p>示例： -FLTTYP S
   *
   * <p>详见国标“MH/T 4029.3-2015” 第15页40行
   */
  @JsonProperty(value = "FLTTYP")
  private String flightType;

  /**
   * 实际起飞日期
   *
   * <p>语法： '-' "ADD" date
   *
   * <p>示例： -ADD 20131022
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页5行
   */
  @JsonProperty(value = "ADD")
  @JsonFormat(pattern = "yyyyMMdd")
  private LocalDate actualDepartureDate;

  /**
   * 实际起飞时间
   *
   * <p>语法： '-' "ATD" timehhmm
   *
   * <p>示例： -ATD 1005
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页17行
   */
  @JsonProperty(value = "ATD")
  @JsonFormat(pattern = "HHmm")
  private LocalTime actualTimeOfDeparture;

  /**
   * 飞行任务类型
   *
   * <p>语法： '-' "TASK" W/Z
   *
   * <p>示例： -TASK W/Z
   */
  @JsonProperty(value = "TASK")
  private String task;

  /**
   * 明语注释（同 AFTN 编组 18 中 RMK/）
   *
   * <p>语法： '-' "RMK" 1{ LIM_CHAR }
   *
   * <p>示例： -RMK TCAS
   *
   * <p>详见国标“MH/T 4029.3-2015” 第17页61行
   */
  @JsonProperty(value = "RMK")
  private String remark;

  /**
   * 预计总飞行时间
   *
   * <p>语法： '-' "TTLEET" timehhmm_elapsed
   *
   * <p>示例： -TTLEET 0036
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页84行
   */
  @JsonProperty(value = "TTLEET")
  @JsonFormat(pattern = "HHmm")
  private LocalTime estimatedElapsedTime;

  /**
   * 飞行日期
   *
   * <p>语法： '-' "DOF" yyMMdd
   *
   * <p>示例： -DOF 181123
   */
  @JsonProperty(value = "DOF")
  @JsonFormat(pattern = "yyMMdd")
  private LocalDate dateOfFlight;

  /**
   * 请求的飞行高度
   *
   * <p>语法： '-' "RFL" flightlevel [point]
   *
   * <p>示例： -RFL F230 REDFA
   *
   * <p>详见国标“MH/T 4029.3-2015” 第17页59行
   */
  @JsonProperty(value = "RFL")
  private String requestLevel;

  /**
   * 指令飞行高度
   *
   * <p>语法： '-' "CFL" flightlevel
   *
   * <p>示例： -CFL S1010
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页20行
   */
  @JsonProperty(value = "CFL")
  private String clearedLevel;

  /**
   * 移交高度
   *
   * <p>语法： '-' "XFL" flightlevel
   *
   * <p>示例： -XFL S1070
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页87行
   */
  @JsonProperty(value = "XFL")
  private String handoffLevel;

  /**
   * 真空速
   *
   * <p>语法： '-' "SPEED" spd [ point ]
   *
   * <p>示例： -SPEED N0402 REDFA
   *
   * <p>详见国标“MH/T 4029.3-2015” 第18页70行
   */
  @JsonProperty(value = "SPEED")
  private String speed;

  /**
   * 当前所属扇区
   *
   * <p>语法： '-' "SECTOR" lpscode
   *
   * <p>示例： - SECTOR AC01
   *
   * <p>详见国标“MH/T 4029.3-2015” 第18页67行
   */
  @JsonProperty(value = "SECTOR")
  private String controlSector;

  /**
   * 自由文本信息
   *
   * <p>语法： '-' " TXT "text20
   *
   * <p>示例： -TXT T084
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页85行
   */
  @JsonProperty(value = "TXT")
  private String information;

  /**
   * 电报18编组，附加信息
   *
   * <p>语法： '-' " TEAM18 " text
   *
   * <p>示例： -TEAM18 PBN/A1B2C1D1L1O2S2 DOF/181123 REG/B6011 EET/ZGZU0115 ZPKM0200 SEL/CFRS
   * CODE/79A060 PER/C1 RMK/TCAS II CAT II APPROVED
   */
  @JsonProperty(value = "TEAM18")
  private String team18;

  /**
   * 是否与监视目标已经相关（N 未相关或掉相关，Y 已经相关）
   *
   * <p>语法： '-' "ISCOUPLE" ('N'|'Y')
   *
   * <p>示例： - ISCOUPLE Y
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页44行
   */
  @JsonProperty(value = "ISCOUPLE")
  private PositiveEnum coupleStatus;

  /**
   * 实际降落日期
   *
   * <p>语法： '-' "ADA" date
   *
   * <p>示例： -ADA 20131022
   *
   * <p>详见国标“MH/T 4029.3-2015” 第13页2行
   */
  @JsonProperty(value = "ADA")
  @JsonFormat(pattern = "yyyyMMdd")
  private LocalDate actualDateOfArrival;

  /**
   * 实际落地时间
   *
   * <p>语法： '-' "ATA" timehhmm
   *
   * <p>示例： -ATA 0845
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页16行
   */
  @JsonProperty(value = "ATA")
  @JsonFormat(pattern = "HHmm")
  private LocalTime actualTimeOfArrival;

  /**
   * 航空器机型（如无 ICAO 定义的标准机型可填入"ZZZZ"）
   *
   * <p>语法： '-' "ARCTYP" (icaoaircrafttype | "ZZZZ")
   *
   * <p>示例： -ARCTYP B737
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页15行
   */
  @JsonProperty(value = "ARCTYP")
  private String aircraftType;

  /**
   * 尾流等级
   *
   * <p>语法： '-' "WKTRC" waketurbcat
   *
   * <p>示例： -WKTRC M
   *
   * <p>详见国标“MH/T 4029.3-2015” 第19页86行
   */
  @JsonProperty(value = "WKTRC")
  private String wakeTurbulenceCategory;

  /**
   * 航空器注册码（同 AFTN 编组 18 中REG/）
   *
   * <p>语法： '-' "REG" 1{ LIM_CHAR }7
   *
   * <p>示例： -REG B2389
   *
   * <p>详见国标“MH/T 4029.3-2015” 第17页60行
   */
  @JsonProperty(value = "REG")
  private String aircraftRegistration;

  /**
   * 无线电通信、导航和进近助航设备（同 AFTN 编组 10 中数据项 A）
   *
   * <p>语法： '-' "CEQPT" aidequipment
   *
   * <p>示例： -CEQPT SRW
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页19行
   */
  @JsonProperty(value = "CEQPT")
  private String communicationCapabilityCode;

  /**
   * 监视设备（同 AFTN 编组 10 中数据项B）
   *
   * <p>语法： '-' "SEQPT" ssrequipment
   *
   * <p>示例： -SEQPT C
   *
   * <p>详见国标“MH/T 4029.3-2015” 第18页66行
   */
  @JsonProperty(value = "SEQPT")
  private String surveillanceCapabilityCode;

  /**
   * 导航设备（同编组 18 中 NAV/）
   *
   * <p>语法： '-' "NAV" text20
   *
   * <p>示例： 暂无
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页48行
   */
  @JsonProperty(value = "NAV")
  private String navigationCapabilityCode;

  /**
   * 区域导航能力信息（同 AFTN 编组 18中 PBN/）
   *
   * <p>语法： '-' "PBN" 1{ALPHANUM}
   *
   * <p>示例： -PBN A1B2C1D1L1O2S2
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页52行
   */
  @JsonProperty(value = "PBN")
  private String performanceBasedNavigationCapabilityCode;

  /**
   * 数据链能力（同 AFTN 编组 18 中DAT/）
   *
   * <p>语法： '-' "DAT" datalink
   *
   * <p>示例： -DAT SV
   *
   * <p>详见国标“MH/T 4029.3-2015” 第14页25行
   */
  @JsonProperty(value = "DAT")
  private String datalinkCommunicationCapabilityCode;

  /**
   * 选择呼叫编码（同 AFTN 编组 18 中SEL/）
   *
   * <p>语法： '-' "SEL" 4{ ALPHA }5
   *
   * <p>示例： -SEL DSGL
   *
   * <p>详见国标“MH/T 4029.3-2015” 第18页65行
   */
  @JsonProperty(value = "SEL")
  private String selectiveCallingCode;

  /**
   * 航空器性能数据（同 AFTN 编组 18 中PER/）
   *
   * <p>语法： '-' "PER" text20
   *
   * <p>示例： -PER C1
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页53行
   */
  @JsonProperty(value = "PER")
  private String performanceProfile;

  /**
   * 航空器经营者名称（同 AFTN 编组 18中 OPR/）
   *
   * <p>语法： '-' "OPR" 1 { LIM_CHAR }
   *
   * <p>示例： -OPR AIR 2000 LTD
   *
   * <p>详见国标“MH/T 4029.3-2015” 第16页50行
   */
  @JsonProperty(value = "OPR")
  private String aircraftOperator;

}
