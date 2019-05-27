/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmovies;

import com.hektorks.take.common.repository.MoviesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GetMoviesCommandBeanInjector {

  private final MoviesRepository moviesRepository;

  GetMoviesCommandBeanInjector(MoviesRepository moviesRepository) {
    this.moviesRepository = moviesRepository;
  }

  @Bean
  GetMoviesCommandBean getGetMoviesCommandBean() {
    return new GetMoviesCommandBeanImpl(moviesRepository);
  }
}