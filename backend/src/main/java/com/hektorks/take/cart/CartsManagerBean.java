/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.cart.model.Cart;

import java.util.UUID;

interface CartsManagerBean {
  Cart getCartById(UUID id);

  void emptyCartById(UUID id);

  void removeCartElement(UUID id, String element);

  void addCartItem(UUID id, String element);
}
