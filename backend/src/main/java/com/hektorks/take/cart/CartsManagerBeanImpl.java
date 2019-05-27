/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.cart.model.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class CartsManagerBeanImpl implements CartsManagerBean {
  private final Map<UUID, Cart> cartsMap;

  CartsManagerBeanImpl() {
    this.cartsMap = new HashMap<>();
  }

  public synchronized Cart getCartById(UUID id) {
    return cartsMap.getOrDefault(id, null);
  }

  public synchronized void emptyCartById(UUID id) {
    cartsMap.remove(id);
  }

  public synchronized void removeCartElement(UUID id, String element) {
    Cart cart = cartsMap.getOrDefault(id, null);
    if (cart != null) {
      cart.removeElement(element);
    }
  }

  public synchronized void addCartItem(UUID id, String element) {
    Cart cart = cartsMap.getOrDefault(id, null);
    if (cart == null) {
      cart = new Cart();
      cartsMap.put(id, cart);
    }
    cart.addElement(element);
  }
}
