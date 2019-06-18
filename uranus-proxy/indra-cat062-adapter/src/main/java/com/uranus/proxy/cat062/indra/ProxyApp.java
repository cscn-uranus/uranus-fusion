package com.uranus.proxy.cat062.indra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

/**
 * ProxyAdcmqApp
 *
 * @author tellxp@github.com
 * @date 2018/11/21
 */
@SpringBootApplication
@EnableIntegration
public class ProxyApp {

  public static void main(String[] args) {
    SpringApplication.run(ProxyApp.class, args);
  }

}
