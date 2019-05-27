/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DatabaseConfigInjector {

  private static final String CONFIG_FILE_NAME = "config.json";
  private static final String DATABASE = "database";

  private JsonFileReader jsonFileReader;

  public DatabaseConfigInjector(JsonFileReader jsonFileReader) {
    this.jsonFileReader = jsonFileReader;
  }

  @Bean
  DatabaseConfig getDatabaseConfig() {
    JSONObject jsonObject = jsonFileReader.read(CONFIG_FILE_NAME);
    return DatabaseConfigMapper.fromJson(jsonObject.getJSONObject(DATABASE));
  }
}
