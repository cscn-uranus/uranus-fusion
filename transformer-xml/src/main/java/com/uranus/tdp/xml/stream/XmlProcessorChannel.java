package com.uranus.tdp.xml.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface XmlProcessorChannel {
  String INPUT = "xml-processor-input";

  String OUTPUT= "xml-processor-output";

  @Input(INPUT)
  SubscribableChannel xml();

  @Output(OUTPUT)
  MessageChannel dump();
}
