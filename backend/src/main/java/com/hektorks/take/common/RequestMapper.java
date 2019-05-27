/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RequestMapper {

  public static <T> List<T> getEnumList(Optional<String> data, Map<String, T> enumValues) {
    if (!data.isPresent()) {
      return null;
    }
    List<T> result = new ArrayList<>();
    String[] values = data.map(item -> item.split(",")).get();
    for (String value : values) {
      T enumElement = enumValues.getOrDefault(value, null);
      if (enumElement != null) {
        result.add(enumElement);
      }
    }
    return result;
  }

}
