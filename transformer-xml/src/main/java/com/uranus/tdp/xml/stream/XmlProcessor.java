package com.uranus.tdp.xml.stream;

import com.uranus.tdp.xml.track.dto.FlightTrackDTO;
import com.uranus.tdp.xml.track.manager.FlightTrackManager;
import com.uranus.tdp.xml.track.mapper.FlightTrackDomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

@MessageEndpoint
@EnableBinding(XmlProcessorChannel.class)
public class XmlProcessor {
  private final Logger logger = LoggerFactory.getLogger(XmlProcessor.class);

  private final FlightTrackManager flightTrackManager;

  public XmlProcessor(FlightTrackManager flightTrackManager) {
    this.flightTrackManager = flightTrackManager;
  }

  @StreamListener(XmlProcessorChannel.INPUT)
  public void process(Message<String> message) {
    this.processFlightTrackXml(message.getPayload());
  }

  private void processFlightTrackXml(String flightTrackText) {
    FlightTrackDTO inputFlightTrackDTO = FlightTrackDomMapper.toDTO(flightTrackText);
    if (inputFlightTrackDTO == null) {
      logger.error("解析FlightTrackDTO失败！");
      return;
    }
    this.flightTrackManager.saveFlightTrackDTO(inputFlightTrackDTO);
  }
}
