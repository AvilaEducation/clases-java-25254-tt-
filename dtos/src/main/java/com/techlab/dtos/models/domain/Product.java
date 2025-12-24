package com.techlab.dtos.models.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

  private Long id;
  private String name;
  private String description;
  private Double price;
  private Integer stock;

  public Product(String name, String description, Double price, Integer stock) {
    this.description = description;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public Product(Long id) {
    this.id = id;
  }

  public Product(Long id, String name, String description, Double price, Integer stock) {
    this.description = description;
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }
}
