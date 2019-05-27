/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmovies;

import com.hektorks.take.common.model.Movie;

import java.util.List;

class GetMoviesResponse {
  private List<Movie> movies;

  private GetMoviesResponse(List<Movie> movies) {
    this.movies = movies;
  }

  static GetMoviesResponse create(List<Movie> movies) {
    return new GetMoviesResponse(movies);
  }

  public List<Movie> getMovies() {
    return movies;
  }
}
