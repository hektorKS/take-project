/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

class CartItemRequest {
  private String movieId;

  String getMovieId() {
    return movieId;
  }

  void setMovieId(String movieId) {
    this.movieId = movieId;
  }
}
