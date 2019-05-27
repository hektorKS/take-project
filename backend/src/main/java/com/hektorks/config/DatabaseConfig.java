/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config;


public class DatabaseConfig {
  private String driver;
  private String url;
  private String username;
  private char[] password;
  private Integer maximumPoolSize;

  private DatabaseConfig(String driver, String url, String username, char[] password, Integer maximumPoolSize) {
    this.driver = driver;
    this.url = url;
    this.username = username;
    this.password = password;
    this.maximumPoolSize = maximumPoolSize;
  }

  public String getDriver() {
    return driver;
  }

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public char[] getPassword() {
    return password;
  }

  public Integer getMaximumPoolSize() {
    return maximumPoolSize;
  }

  static DatabaseConfigBuilder builder() {
    return new DatabaseConfigBuilder();
  }

  public static class DatabaseConfigBuilder {
    private String driver;
    private String url;
    private String username;
    private char[] password;
    private Integer maximumPoolSize;

    DatabaseConfigBuilder setDriver(String driver) {
      this.driver = driver;
      return this;
    }

    DatabaseConfigBuilder setUrl(String url) {
      this.url = url;
      return this;
    }

    DatabaseConfigBuilder setUsername(String username) {
      this.username = username;
      return this;

    }

    DatabaseConfigBuilder setPassword(char[] password) {
      this.password = password;
      return this;
    }

    DatabaseConfigBuilder setMaximumPoolSize(Integer maximumPoolSize) {
      this.maximumPoolSize = maximumPoolSize;
      return this;
    }

    DatabaseConfig build() {
      return new DatabaseConfig(
          this.driver,
          this.url,
          this.username,
          this.password,
          this.maximumPoolSize
      );
    }
  }
}