/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.ibatis.type.Alias;

import java.util.HashMap;
import java.util.Map;

@Alias("MovieCategory")
public enum MovieCategory {
  DRAMA("DRAMA"),
  COMEDY("COMEDY"),
  FAMILY("FAMILY"),
  ACTION("ACTION"),
  SCI_FI("SCI-FI"),
  CLASSICS("CLASSICS");

  private final String name;

  public static Map<String, MovieCategory> categoriesMap = new HashMap<>();

  static {
    for (MovieCategory category : MovieCategory.values()) {
      categoriesMap.put(category.name, category);
    }
  }

  MovieCategory(String name) {
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return name;
  }


  public static MovieCategory fromString(String value) {
    return categoriesMap.getOrDefault(value, null);
  }
}
