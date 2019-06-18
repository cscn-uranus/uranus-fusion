package com.uranus.proxy.adcmq.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * ProxyAdcmqProcessor
 *
 * @author tellxp@github.com
 * @date 2018/11/21
 */

@EnableJms
@EnableBinding(AdcmqProxyChannel.class)
public class ProxyAdcmqProcessor {

  private static final Logger logger= LoggerFactory.getLogger(ProxyAdcmqProcessor.class);

  private final AdcmqProxyChannel adcmqProxyChannel;

  public ProxyAdcmqProcessor(AdcmqProxyChannel adcmqProxyChannel) {
    this.adcmqProxyChannel = adcmqProxyChannel;
  }

  @JmsListener(destination = "CNCDEV_INTEGRATE_FLIGHT_INFO_OUTPUT")
  public void proxyIntegrateFlightInfo(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.integrateFlightInfo().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_CDM_MQ_FLOW_CONTROL_OUTPUT")
  public void proxyCdmFlowControl(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.cdmFlowControl().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_AIMS_NONSKED_PLAN_OUTPUT")
  public void proxyAimsNonSkedPlan(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.aimsNonSkedPlan().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_AIMS_SKED_PLAN_OUTPUT")
  public void proxyAimsSkedPlan(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.aimsSkedPlan().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_SPECLAL_PLANE_NOTICE_OUTPUT")
  public void proxySipdsSpecialPlaneNotice(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsSpecialPlaneNotice().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_ELE_AWOS_OUTPUT")
  public void proxySipdsAwos(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsAwos().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_RPT01_OUTPUT")
  public void proxySipdsRpt(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsRpt().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_NOTAM_OUTPUT")
  public void proxySipdsNotam(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsNotam().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_COM_AIR_TEST_FLIGHT_INFO_OUTPUT")
  public void proxySipdsComAirTestFlightInfo(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();

    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsComAirTestFlightInfo().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_FLOW_CONTROL")
  public void proxySipdsFlowControl(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsFlowControl().send(outputMessage);
  }

  @JmsListener(destination = "CNCDEV_SIPDS_AF_DYNA")
  public void proxySipdsAfDyna(Message<String> inputMessage) {

    String payload = inputMessage.getPayload();
    Message<String> outputMessage = MessageBuilder.withPayload(payload).build();
    this.adcmqProxyChannel.sipdsAfDyna().send(outputMessage);
  }
}
