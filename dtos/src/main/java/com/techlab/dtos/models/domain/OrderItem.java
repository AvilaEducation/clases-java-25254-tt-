package com.techlab.dtos.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {

  private Long id;
  private Product product;
  private Integer amount;

  public OrderItem(Product product, Integer amount) {
    this.product = product;
    this.amount = amount;
  }

  public OrderItem(Long id, Integer amount, Product product) {
    this.id = id;
    this.amount = amount;
    this.product = product;
  }

  public Double getPrice() {
    return this.product.getPrice() * this.amount;
  }

  public Long getProductId() {
    return this.product.getId();
  }
}
