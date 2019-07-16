package com.uranus.toolkit.udp.unicast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author tellxp@github.com
 * @date 2019/7/9
 */
@SpringBootApplication
@EnableIntegration
@ComponentScan({"com.uranus.toolkit"})
public class UnicastSplitterApp {
  public static void main(String[] args) {
    SpringApplication.run(UnicastSplitterApp.class, args);
  }
}
