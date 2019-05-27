/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.cart.model.Cart;
import com.hektorks.take.cart.model.CartDetails;

interface CartDetailsFactory {
  CartDetails create(Cart cart);
}
