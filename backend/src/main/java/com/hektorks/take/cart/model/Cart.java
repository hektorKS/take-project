/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {
  private final Set<String> movies;

  public Cart() {
    this.movies = new HashSet<>();
  }

  public void addElement(String element) {
    movies.add(element);
  }

  public void removeElement(String element) {
    movies.remove(element);
  }

  public Set<String> getMovies() {
    return movies;
  }
}
