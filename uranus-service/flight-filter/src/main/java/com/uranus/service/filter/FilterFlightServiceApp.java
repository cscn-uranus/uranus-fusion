package com.uranus.service.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author XiaoPeng
 */
@SpringBootApplication
@EnableJms
public class FilterFlightServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(FilterFlightServiceApp.class, args);
  }
}
