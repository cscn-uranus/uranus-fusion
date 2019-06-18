package com.uranus.toolkit.forward.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 11:49
 */
@Component
public interface RabbitInChannel {
  String INPUT = "rabbit-in";

  @Input(INPUT)
  SubscribableChannel rabbitIn();
}
