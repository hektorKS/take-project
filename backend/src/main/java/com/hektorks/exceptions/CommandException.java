/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.exceptions;

public class CommandException extends RuntimeException {
  public CommandException(String message, Throwable cause) {
    super(message, cause);
  }
}