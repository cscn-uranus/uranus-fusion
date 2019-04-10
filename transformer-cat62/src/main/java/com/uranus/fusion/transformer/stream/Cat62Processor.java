package com.uranus.fusion.transformer.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uranus.fusion.asterix.Cat062Mapper;
import com.uranus.fusion.transformer.dto.FlightDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Cat62ProcessorChannel.class)
public class Cat62Processor {
  private final Logger logger = LoggerFactory.getLogger(Cat62Processor.class);

  @StreamListener(Cat62ProcessorChannel.INPUT)
  public void process(Message<byte[]> message) {

    byte[] receivedBytes= message.getPayload();
    Cat062Mapper mapper = new Cat062Mapper(receivedBytes);
    FlightDTO cat62UapDTO = mapper.readValue();
    ObjectMapper jsonMapper = new ObjectMapper();
    try {
      logger.info(jsonMapper.writeValueAsString(cat62UapDTO));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

  }
}
