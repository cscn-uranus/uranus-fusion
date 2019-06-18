package com.uranus.proxy.trackxml;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * TrackXmlPublisher
 *
 * @author 肖鹏
 * @date 2018/11/8
 */
@Component
public interface TrackXmlPublisher {

  String OUTPUT = "trackxml-publisher";

  @Output(OUTPUT)
  MessageChannel trackXmlText();
}

