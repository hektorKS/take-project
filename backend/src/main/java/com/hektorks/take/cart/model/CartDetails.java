/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart.model;

import com.hektorks.take.common.model.Movie;

import java.util.List;

public class CartDetails {
  private List<Movie> movies;
  private double sumPln;
  private double sumEur;

  public CartDetails(List<Movie> movies, double sumPln, double sumEur) {
    this.movies = movies;
    this.sumPln = sumPln;
    this.sumEur = sumEur;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public double getSumPln() {
    return sumPln;
  }

  public double getSumEur() {
    return sumEur;
  }
}
