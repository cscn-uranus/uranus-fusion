package com.uranus.proxy.fdexm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
public class ProxyFdexmApp {
  public static void main(String[] args) {
    SpringApplication.run(ProxyFdexmApp.class, args);
  }
}
