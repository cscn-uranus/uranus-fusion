package com.uranus.fusion.transformer.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uranus.fusion.transformer.asterix.Cat62Mapper;
import com.uranus.fusion.transformer.asterix.Cat62UapDTO;
import com.uranus.fusion.transformer.entity.Cat62Probe;
import com.uranus.fusion.transformer.repo.FspecRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@EnableBinding(Cat62ProcessorChannel.class)
public class Cat62Processor {
  private final Logger logger = LoggerFactory.getLogger(Cat62Processor.class);
  private final FspecRepo fspecRepo;

  public Cat62Processor(FspecRepo fspecRepo) {

    this.fspecRepo = fspecRepo;
  }

  @StreamListener(Cat62ProcessorChannel.INPUT)
  public void process(Message<byte[]> message) {

    byte[] receivedBytes= message.getPayload();
    Cat62Mapper mapper = new Cat62Mapper(receivedBytes);
    Cat62UapDTO cat62UapDTO = mapper.readValue();
    ObjectMapper  jsonMapper = new ObjectMapper();
    try {
      logger.info(jsonMapper.writeValueAsString(cat62UapDTO));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}