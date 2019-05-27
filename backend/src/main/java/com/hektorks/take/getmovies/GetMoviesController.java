/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmovies;

import com.hektorks.take.common.RequestMapper;
import com.hektorks.take.common.model.Movie;
import com.hektorks.take.common.model.MovieCategory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
class GetMoviesController {
  private final GetMoviesCommandBean moviesCommandBean;

  public GetMoviesController(GetMoviesCommandBean moviesCommandBean) {
    this.moviesCommandBean = moviesCommandBean;
  }

  @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity getMovies(@RequestParam("type") Optional<String> types) {

    List<MovieCategory> categories = RequestMapper.getEnumList(types, MovieCategory.categoriesMap);
    List<Movie> movies = moviesCommandBean.execute(categories);
    return ResponseEntity.ok(GetMoviesResponse.create(movies));
  }
}