/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart.mapper;

import java.text.DecimalFormat;

public class DoubleTrimBean {
  private static final String COMMA = ",";
  private static final String DOT = ".";
  private static final String DOUBLE_FORMAT = "#.##";

  private static DecimalFormat decimalFormat = new DecimalFormat(DOUBLE_FORMAT);

  public static double trimDouble(double value) {
    String x = decimalFormat.format(value).replace(COMMA, DOT);
    return Double.parseDouble(x);
  }
}
