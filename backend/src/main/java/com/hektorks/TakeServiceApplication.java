/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class TakeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TakeServiceApplication.class, args);
  }

}