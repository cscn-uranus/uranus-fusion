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
public class UdpMulti2UniApp {

  public static void main(String[] args) {
    SpringApplication.run(UdpMulti2UniApp.class, args);
  }

}
