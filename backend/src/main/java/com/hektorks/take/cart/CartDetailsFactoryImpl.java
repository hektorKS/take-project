/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.cart.mapper.CurrencyMapper;
import com.hektorks.take.cart.mapper.DoubleTrimBean;
import com.hektorks.take.cart.model.Cart;
import com.hektorks.take.cart.model.CartDetails;
import com.hektorks.take.common.model.Movie;
import com.hektorks.take.getmoviebyid.GetMovieByIdCommandBean;

import java.util.ArrayList;
import java.util.List;

class CartDetailsFactoryImpl implements CartDetailsFactory {


  private final GetMovieByIdCommandBean getMovieByIdCommandBean;

  CartDetailsFactoryImpl(GetMovieByIdCommandBean getMovieByIdCommandBean) {
    this.getMovieByIdCommandBean = getMovieByIdCommandBean;
  }

  public CartDetails create(Cart cart) {
    if (cart == null) {
      return null;
    }

    List<Movie> result = new ArrayList<>();
    for (String movieId : cart.getMovies()) {
      result.add(getMovieByIdCommandBean.execute(movieId));
    }
    double sumPln = result.stream()
        .map(Movie::getPrice)
        .reduce(0.0f, Float::sum)
        .doubleValue();

    return new CartDetails(
        result,
        DoubleTrimBean.trimDouble(sumPln),
        DoubleTrimBean.trimDouble(CurrencyMapper.plnToDouble(sumPln))
    );
  }
}
