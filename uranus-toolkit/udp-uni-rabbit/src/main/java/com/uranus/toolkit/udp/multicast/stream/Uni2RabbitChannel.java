package com.uranus.toolkit.udp.multicast.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 15:41
 */
@Component
public interface Uni2RabbitChannel {
  String OUTPUT = "bridge-output";

  @Output(OUTPUT)
  MessageChannel bridge();
}
