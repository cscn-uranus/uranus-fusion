package com.uranus.transformer.fdexm.util;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class MessageUtil {
  public static Message toMessage(Object payload) {
    return MessageBuilder.withPayload(payload).build();
  }
}
