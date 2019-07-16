package com.uranus.service.filter.stream;

import com.uranus.transition.common.dto.FlightDTO;
import com.uranus.transition.common.util.JacksonUtil;
import com.uranus.service.filter.config.FlightFilterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/** @author XiaoPeng */
@Component
@EnableConfigurationProperties(FlightFilterProperties.class)
@EnableBinding(FlightFilterChannel.class)
@Slf4j
public class FlightFilterProcessor {

  private static final String WILDCARD = "*";

  private final FlightFilterProperties flightFilterProperties;
  private final JmsMessagingTemplate jmsTemplate;

  public FlightFilterProcessor(
      FlightFilterProperties flightFilterProperties, JmsMessagingTemplate jmsTemplate) {
    this.flightFilterProperties = flightFilterProperties;
    this.jmsTemplate = jmsTemplate;
  }

  @StreamListener(FlightFilterChannel.INPUT)
  public void process(FlightDTO flightDTO) {
    String callsignPrefixRestriction = flightFilterProperties.getCallsignPrefixRestriction();
    if (null == callsignPrefixRestriction) {
      return;
    }

    String flightIdentification = flightDTO.getFlightIdentification();
    if (null == flightIdentification) {
      return;
    }

    if (WILDCARD.equals(callsignPrefixRestriction)
        || flightIdentification.startsWith(callsignPrefixRestriction)) {
      try {
        String xmlText = JacksonUtil.objToXml(flightDTO);
        String queue = flightFilterProperties.getQueue();
        log.info("发送flightDTO，航班号为："+flightIdentification);
        jmsTemplate.convertAndSend(queue, xmlText);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
