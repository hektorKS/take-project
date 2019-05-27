/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config.exceptions;

public class MissingConfigurationException extends RuntimeException {
  public MissingConfigurationException(String fileName, Throwable cause) {
    super("Missing configuration file: " + fileName + ".", cause);
  }
}
