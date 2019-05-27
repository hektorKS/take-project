/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart.mapper;

public class CurrencyMapper {
  private static final double PLN_TO_EURO_RATIO = 0.232956512;

  public static double plnToDouble(double value) {
    return value * PLN_TO_EURO_RATIO;
  }
}
