package com.uranus.service.filter.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
public interface FlightFilterChannel {
  String INPUT = "flight-input";

  @Input(INPUT)
  SubscribableChannel indraFlightTrack();
}
