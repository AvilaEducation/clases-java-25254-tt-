package com.techlab.dtos.models.entity;

import com.techlab.dtos.models.domain.OrderItem;
import com.techlab.dtos.models.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class OrderItemMySQL {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private ProductMySQL product;
  private Integer amount;

  public void setProduct(ProductMySQL product) {
    this.product = product;
  }

  public OrderItemMySQL() {
  }

  public OrderItemMySQL(ProductMySQL product, Integer amount) {
    this.product = product;
    this.amount = amount;
  }

  public static OrderItemMySQL fromDomain(OrderItem orderItem) {
    ProductMySQL product = ProductMySQL.fromProductDomain(orderItem.getProduct());
    return new OrderItemMySQL(product, orderItem.getAmount());
  }

  public static OrderItem toDomain(OrderItemMySQL orderItemMySQL) {
    Product product = ProductMySQL.toDomain(orderItemMySQL.getProduct());
    return new OrderItem(orderItemMySQL.getId(), orderItemMySQL.getAmount(), product);
  }
}
