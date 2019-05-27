/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;

import com.hektorks.config.exceptions.MissingConfigurationException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

class JsonFileReaderImpl implements JsonFileReader {

  private static Logger logger = LoggerFactory.getLogger(JsonFileReaderImpl.class);

  @Override
  public JSONObject read(String fileName) {
    try {
      String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
      return new JSONObject(jsonString);
    } catch (Exception exception) {
      logger.error("Cannot read json file {}!", fileName);
      throw new MissingConfigurationException(fileName, exception);
    }
  }
}
