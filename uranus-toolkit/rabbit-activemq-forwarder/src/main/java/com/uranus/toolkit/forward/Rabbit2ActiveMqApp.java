package com.uranus.toolkit.forward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 11:38
 */
@SpringBootApplication
@EnableJms
public class Rabbit2ActiveMqApp {
  public static void main(String[] args) {
    SpringApplication.run(Rabbit2ActiveMqApp.class, args);
  }

}
