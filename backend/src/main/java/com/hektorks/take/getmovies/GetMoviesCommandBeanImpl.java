/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmovies;

import com.hektorks.exceptions.CommandException;
import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;
import com.hektorks.take.common.repository.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class GetMoviesCommandBeanImpl implements GetMoviesCommandBean {
  private static Logger logger = LoggerFactory.getLogger(GetMoviesCommandBeanImpl.class);

  private final MoviesRepository moviesRepository;

  GetMoviesCommandBeanImpl(MoviesRepository moviesRepository) {
    this.moviesRepository = moviesRepository;
  }

  @Override
  public List<Movie> execute(List<MovieCategory> categories) {
    try {
      return moviesRepository.getMovies(categories);
    } catch (Exception exception) {
      logger.warn("Getting movies list failed.", exception);
      throw new CommandException("Getting users list failed.", exception);
    }
  }
}