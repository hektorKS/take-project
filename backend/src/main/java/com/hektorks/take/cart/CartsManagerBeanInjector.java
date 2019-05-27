/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CartsManagerBeanInjector {

  @Bean
  CartsManagerBean getCart(){
    return new CartsManagerBeanImpl();
  }
}
