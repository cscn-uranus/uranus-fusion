package com.uranus.proxy.fdexm.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author 肖鹏
 */
@Component
public interface FdexmProxyChannel {

  String OUTPUT = "udp-fdexm";

  @Output(OUTPUT)
  MessageChannel fdexm();
}
