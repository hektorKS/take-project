/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.repository.mappers;

import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;

import java.util.List;

public interface MoviesMapper {
  List<Movie> selectMoviesByTypes(List<MovieCategory> categories);

  Movie selectMovieById(String movieId);
}
