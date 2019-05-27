/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class JsonFileReaderInjector {

  @Bean
  public JsonFileReader getJsonFileReader() {
    return new JsonFileReaderImpl();
  }
}
