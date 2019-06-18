package com.uranus.proxy.cat062.sw.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface ProxyChannel {

  String OUTPUT = "cat062-proxy-output";

  @Output(OUTPUT)
  MessageChannel cat62();
}
