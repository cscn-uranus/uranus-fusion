package com.uranus.fusion.transformer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface Cat62ProcessorChannel {
  String INPUT = "cat62-processor-input";


  @Input(INPUT)
  SubscribableChannel cat62();

}
