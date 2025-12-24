package com.techlab.dtos.models.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Order {

  private Long id;
  private String name;
  private List<OrderItem> orderItems;

  public Order(String name, List<OrderItem> orderItems) {
    this.name = name;
    this.orderItems = orderItems;
  }

  public Order(Long id, String name, List<OrderItem> orderItems) {
    this.id = id;
    this.name = name;
    this.orderItems = orderItems;
  }

  public Double getTotalPrice() {
    Double totalPrice = 0.0;
    for (OrderItem orderItem : orderItems) {
      totalPrice += orderItem.getPrice();
    }

    return totalPrice;
  }

  public List<Long> getProductIds() {
    List<Long> productIds = new ArrayList<>();
    for (OrderItem orderItem : orderItems) {
      productIds.add(orderItem.getProductId());
    }

    return productIds;
  }
}
