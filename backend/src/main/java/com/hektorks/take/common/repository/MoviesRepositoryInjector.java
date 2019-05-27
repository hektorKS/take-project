/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MoviesRepositoryInjector {

  private final SqlSessionTemplate sqlSessionTemplate;

  MoviesRepositoryInjector(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }

  @Bean
  MoviesRepository getMoviesRepository() {
    return new MoviesRepositoryImpl(sqlSessionTemplate);
  }

}