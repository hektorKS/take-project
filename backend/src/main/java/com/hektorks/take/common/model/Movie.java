/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.common.model;

import org.apache.ibatis.type.Alias;

@Alias("Movie")
public class Movie {
  private String id;
  private String title;
  private MovieCategory movieCategory;
  private int year;
  private String cast;
  private String director;
  private String story;
  private float price;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MovieCategory getMovieCategory() {
    return movieCategory;
  }

  public void setMovieCategory(MovieCategory movieCategory) {
    this.movieCategory = movieCategory;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getCast() {
    return cast;
  }

  public void setCast(String cast) {
    this.cast = cast;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getStory() {
    return story;
  }

  public void setStory(String story) {
    this.story = story;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
