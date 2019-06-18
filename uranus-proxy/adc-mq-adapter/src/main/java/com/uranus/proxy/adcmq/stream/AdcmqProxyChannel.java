package com.uranus.proxy.adcmq.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
/**
 * AdcmqProxyChannel
 *
 * @author 肖鹏
 * @date 2018/11/8
 */
@Component
public interface AdcmqProxyChannel {

  /**
   * CNCDEV_INTEGRATE_FLIGHT_INFO_OUTPUT
   */
  String OUTPUT_INTEGRATE_FI = "adcmq-integrate-fi";
  @Output(OUTPUT_INTEGRATE_FI)
  MessageChannel integrateFlightInfo();

  /**
   * CNCDEV_CDM_MQ_FLOW_CONTROL_OUTPUT
   */
  String OUTPUT_CDM_FC = "adcmq-cdm-fc";
  @Output(OUTPUT_CDM_FC)
  MessageChannel cdmFlowControl();

  /**
   * CNCDEV_AIMS_NONSKED_PLAN_OUTPUT
   */
  String OUTPUT_AIMS_NSP = "adcmq-aims-nsp";
  @Output(OUTPUT_AIMS_NSP)
  MessageChannel aimsNonSkedPlan();

  /**
   * CNCDEV_AIMS_SKED_PLAN_OUTPUT
   */
  String OUTPUT_AIMS_SP = "adcmq-aims-sp";
  @Output(OUTPUT_AIMS_SP)
  MessageChannel aimsSkedPlan();

  /**
   * CNCDEV_SIPDS_SPECLAL_PLANE_NOTICE_OUTPUT
   */
  String OUTPUT_SIPDS_SPN = "adcmq-sipds-spn";
  @Output(OUTPUT_SIPDS_SPN)
  MessageChannel sipdsSpecialPlaneNotice();

  /**
   * CNCDEV_SIPDS_ELE_AWOS_OUTPUT
   */
  String OUTPUT_SIPDS_AWOS = "adcmq-sipds-awos";
  @Output(OUTPUT_SIPDS_AWOS)
  MessageChannel sipdsAwos();

  /**
   * CNCDEV_SIPDS_RPT01_OUTPUT
   */
  String OUTPUT_SIPDS_RPT = "adcmq-sipds-rpt";
  @Output(OUTPUT_SIPDS_RPT)
  MessageChannel sipdsRpt();

  /**
   * CNCDEV_SIPDS_NOTAM_OUTPUT
   */
  String OUTPUT_SIPDS_NOTAM = "adcmq-sipds-notam";
  @Output(OUTPUT_SIPDS_NOTAM)
  MessageChannel sipdsNotam();

  /**
   * CNCDEV_SIPDS_COM_AIR_TEST_FLIGHT_INFO_OUTPUT
   */
  String OUTPUT_SIPDS_CATFI = "adcmq-sipds-catfi";
  @Output(OUTPUT_SIPDS_CATFI)
  MessageChannel sipdsComAirTestFlightInfo();

  /**
   * CNCDEV_SIPDS_FLOW_CONTROL
   */
  String OUTPUT_SIPDS_FC = "adcmq-sipds-fc";
  @Output(OUTPUT_SIPDS_FC)
  MessageChannel sipdsFlowControl();

  /**
   * CNCDEV_SIPDS_AF_DYNA
   */
  String OUTPUT_SIPDS_AD = "adcmq-sipds-ad";
  @Output(OUTPUT_SIPDS_AD)
  MessageChannel sipdsAfDyna();

}
