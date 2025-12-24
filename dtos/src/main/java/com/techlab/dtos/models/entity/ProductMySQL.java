package com.techlab.dtos.models.entity;

import com.techlab.dtos.models.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_mysql")
public class ProductMySQL {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private Double price;
  private Integer stock;

  @OneToMany(mappedBy = "product")
  private List<OrderItemMySQL> orderItems;

  public ProductMySQL() {
  }

  public ProductMySQL(Long id, String name, String description, Double price, Integer stock) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  public static ProductMySQL fromProductDomain(Product product) {
    return new ProductMySQL(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getStock()
    );
  }

  public static Product toDomain(ProductMySQL productMySQL) {
    return new Product(
        productMySQL.getId(),
        productMySQL.getName(),
        productMySQL.getDescription(),
        productMySQL.getPrice(),
        productMySQL.getStock()
    );
  }
}
