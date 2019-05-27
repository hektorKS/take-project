/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmovies;

import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;

import java.util.List;

public interface GetMoviesCommandBean {
  List<Movie> execute(List<MovieCategory> categories);
}