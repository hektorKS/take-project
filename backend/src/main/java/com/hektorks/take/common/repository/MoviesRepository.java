/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.repository;

import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;

import java.util.List;

public interface MoviesRepository {

  List<Movie> getMovies(List<MovieCategory> categories);

  Movie getMovieById(String movieId);

}