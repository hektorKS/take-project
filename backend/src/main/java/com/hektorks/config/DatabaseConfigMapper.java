/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;

import com.hektorks.config.exceptions.InvalidConfigurationException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DatabaseConfigMapper {

  private static final String DRIVER = "driver";
  private static final String URL = "url";
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  private static final String MAXIMUM_POOL_SIZE = "maximumPoolSize";

  private static Logger logger = LoggerFactory.getLogger(DatabaseConfigMapper.class);

  static DatabaseConfig fromJson(JSONObject jsonObject) {
    try {
      return DatabaseConfig
          .builder()
          .setDriver(jsonObject.getString(DRIVER))
          .setUrl(jsonObject.getString(URL))
          .setUsername(jsonObject.getString(USERNAME))
          .setPassword(jsonObject.getString(PASSWORD).toCharArray())
          .setMaximumPoolSize(jsonObject.getInt(MAXIMUM_POOL_SIZE))
          .build();
    } catch (Exception exception) {
      logger.error("Invalid security configuration!");
      throw new InvalidConfigurationException(jsonObject, exception);
    }
  }
}
