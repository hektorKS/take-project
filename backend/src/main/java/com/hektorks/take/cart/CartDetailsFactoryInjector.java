/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.getmoviebyid.GetMovieByIdCommandBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CartDetailsFactoryInjector {

  private final GetMovieByIdCommandBean getMovieByIdCommandBean;

  CartDetailsFactoryInjector(GetMovieByIdCommandBean getMovieByIdCommandBean) {
    this.getMovieByIdCommandBean = getMovieByIdCommandBean;
  }

  @Bean
  CartDetailsFactory getCartDetailsFactory() {
    return new CartDetailsFactoryImpl(getMovieByIdCommandBean);
  }
}
