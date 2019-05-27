/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;

import org.json.JSONObject;

public interface JsonFileReader {
  JSONObject read(String fileName);
}
