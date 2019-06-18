package com.uranus.toolkit.udp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:20
 */
@SpringBootApplication
@EnableIntegration
public class UdpUni2RabbitApp {
  public static void main(String[] args) {
    SpringApplication.run(UdpUni2RabbitApp.class, args);
  }
}
