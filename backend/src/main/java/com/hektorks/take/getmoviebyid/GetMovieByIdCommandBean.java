/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmoviebyid;

import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;

import java.util.List;

public interface GetMovieByIdCommandBean {
  Movie execute(String movieId);
}