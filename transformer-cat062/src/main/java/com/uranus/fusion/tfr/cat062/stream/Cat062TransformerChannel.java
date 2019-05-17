package com.uranus.fusion.tfr.cat062.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
public interface Cat062TransformerChannel {
  String INPUT = "cat62-transformer-input";

  @Input(INPUT)
  SubscribableChannel cat62();
}
