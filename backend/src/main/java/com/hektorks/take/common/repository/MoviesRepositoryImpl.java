/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.repository;

import com.hektorks.exceptions.RepositoryException;
import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;
import com.hektorks.take.common.repository.mappers.MoviesMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
class MoviesRepositoryImpl implements MoviesRepository {
  private static Logger logger = LoggerFactory.getLogger(MoviesRepositoryImpl.class);

  private final SqlSessionTemplate sqlSessionTemplate;

  MoviesRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }

  @Override
  public List<Movie> getMovies(List<MovieCategory> categories) {
    try {
      MoviesMapper moviesMapper = sqlSessionTemplate.getMapper(MoviesMapper.class);
      return moviesMapper.selectMoviesByTypes(categories);
    } catch (Exception exception) {
      logger.warn("Getting movies from database failed.", exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public Movie getMovieById(String movieId) {
    try {
      MoviesMapper moviesMapper = sqlSessionTemplate.getMapper(MoviesMapper.class);
      return moviesMapper.selectMovieById(movieId);
    } catch (Exception exception) {
      logger.warn("Getting movie by id from database failed.", exception);
      throw new RepositoryException(exception);
    }
  }
}