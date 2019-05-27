/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config.exceptions;

import org.json.JSONObject;

public class InvalidConfigurationException extends RuntimeException {
  public InvalidConfigurationException(JSONObject jsonObject, Throwable cause) {
    super("Invalid configuration file: " + jsonObject + ".", cause);
  }
}
