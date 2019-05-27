/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmoviebyid;

import com.hektorks.take.common.repository.MoviesRepository;
import com.hektorks.take.getmovies.GetMoviesCommandBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GetMovieByIdCommandBeanInjector {

  private final MoviesRepository moviesRepository;

  GetMovieByIdCommandBeanInjector(MoviesRepository moviesRepository) {
    this.moviesRepository = moviesRepository;
  }

  @Bean
  GetMovieByIdCommandBean getGetMovieByIdCommandBean() {
    return new GetMovieByIdCommandBeanImpl(moviesRepository);
  }
}