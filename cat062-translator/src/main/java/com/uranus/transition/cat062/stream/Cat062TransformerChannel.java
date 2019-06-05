package com.uranus.transition.cat062.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
public interface Cat062TransformerChannel {
  String INPUT = "cat062-transformer-input";
  String OUTPUT="cat062-transformer-output";

  @Input(INPUT)
  SubscribableChannel cat062();

  @Output(OUTPUT)
  MessageChannel flight();
}
