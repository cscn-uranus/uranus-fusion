package com.uranus.fusion.tfr.cat062.modesel.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
public interface ModeSelTransformerChannel {
  String INPUT = "modesel-transformer-input";

  @Input(INPUT)
  SubscribableChannel indraCat062();
}
