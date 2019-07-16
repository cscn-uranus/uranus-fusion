package com.uranus.proxy.cat062.indra.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
public interface ProxyChannel {

  String OUTPUT = "proxy-eucat062-indra-output";

  @Output(OUTPUT)
  MessageChannel indraCat062();
}
