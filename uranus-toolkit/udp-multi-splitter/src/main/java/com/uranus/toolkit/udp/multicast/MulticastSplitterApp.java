package com.uranus.toolkit.udp.multicast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:20
 */
@SpringBootApplication
@EnableIntegration
public class MulticastSplitterApp {

  public static void main(String[] args) {
    SpringApplication.run(MulticastSplitterApp.class, args);
  }

}
