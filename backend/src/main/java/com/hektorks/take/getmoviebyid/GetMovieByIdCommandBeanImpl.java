/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmoviebyid;

import com.hektorks.exceptions.CommandException;
import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.repository.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GetMovieByIdCommandBeanImpl implements GetMovieByIdCommandBean {
  private static Logger logger = LoggerFactory.getLogger(GetMovieByIdCommandBeanImpl.class);

  private final MoviesRepository moviesRepository;

  GetMovieByIdCommandBeanImpl(MoviesRepository moviesRepository) {
    this.moviesRepository = moviesRepository;
  }

  @Override
  public Movie execute(String movieId) {
    try {
      return moviesRepository.getMovieById(movieId);
    } catch (Exception exception) {
      logger.warn("Getting movie by id {} failed.", movieId, exception);
      throw new CommandException("Getting movie by id " + movieId + " failed.", exception);
    }
  }
}