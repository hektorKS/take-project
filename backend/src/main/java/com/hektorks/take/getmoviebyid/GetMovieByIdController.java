/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.getmoviebyid;

import com.hektorks.take.common.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
class GetMovieByIdController {
  private final GetMovieByIdCommandBean getMovieByIdCommandBean;

  GetMovieByIdController(GetMovieByIdCommandBean getMovieByIdCommandBean) {
    this.getMovieByIdCommandBean = getMovieByIdCommandBean;
  }

  @GetMapping(value = "/movie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity getMovies(@PathVariable String movieId) {

    Movie movie = getMovieByIdCommandBean.execute(movieId);
    return ResponseEntity.ok(movie);
  }
}