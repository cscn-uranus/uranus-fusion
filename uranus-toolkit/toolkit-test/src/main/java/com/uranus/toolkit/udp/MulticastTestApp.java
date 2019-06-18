package com.uranus.toolkit.udp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author tellxp@github.com
 * @date 2019/5/30 12:01
 */

@SpringBootApplication
public class MulticastTestApp  {


  @PostConstruct
  public void initIt() throws Exception {
      MulticastEchoServer server = new MulticastEchoServer();
      server.start();
  }

  public static void main(String[] args) {
    SpringApplication.run(MulticastTestApp.class, args);
  }
}
