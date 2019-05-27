/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.take.cart;

import com.hektorks.take.cart.model.Cart;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
class CartController {
  private final CartsManagerBean cartsManagerBean;
  private final CartDetailsFactory cartDetailsFactory;

  CartController(CartsManagerBean cartsManagerBean, CartDetailsFactory cartDetailsFactory) {
    this.cartsManagerBean = cartsManagerBean;
    this.cartDetailsFactory = cartDetailsFactory;
  }

  @PostMapping(value = "/cart/{cartId}/item")
  ResponseEntity addCartItem(@PathVariable UUID cartId, @RequestBody CartItemRequest body) {
    if (body.getMovieId() == null) {
      return ResponseEntity.badRequest().body(null);
    }
    cartsManagerBean.addCartItem(cartId, body.getMovieId());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/cart/{cartId}/item")
  ResponseEntity removeCartItem(@PathVariable UUID cartId, @RequestBody CartItemRequest body) {
    if (body.getMovieId() == null) {
      return ResponseEntity.badRequest().body(null);
    }
    cartsManagerBean.removeCartElement(cartId, body.getMovieId());
    return ResponseEntity.noContent().build();
  }

  @GetMapping(value = "/cart/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity getCart(@PathVariable UUID cartId, @RequestParam("details") Optional<Boolean> details) {
    Cart cart = cartsManagerBean.getCartById(cartId);
    if (cart == null) {
      return ResponseEntity.notFound().build();
    }
    if (details.isPresent() && details.get().equals(true)) {
      return ResponseEntity.ok(cartDetailsFactory.create(cart));
    }
    return ResponseEntity.ok(cart);
  }

  @DeleteMapping(value = "/cart/{cartId}")
  ResponseEntity deleteCart(@PathVariable UUID cartId) {
    cartsManagerBean.emptyCartById(cartId);
    return ResponseEntity.noContent().build();
  }
}