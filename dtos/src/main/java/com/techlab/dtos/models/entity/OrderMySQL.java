package com.techlab.dtos.models.entity;

import com.techlab.dtos.models.domain.Order;
import com.techlab.dtos.models.domain.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class OrderMySQL {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private List<OrderItemMySQL> orderItems;

  public OrderMySQL() {
  }

  public OrderMySQL(String name, List<OrderItemMySQL> orderItems) {
    this.name = name;
    this.orderItems = orderItems;
  }

  public static OrderMySQL fromDomain(Order orderDomain) {
    List<OrderItemMySQL> orderItemMySQLS = new ArrayList<>();
    for (OrderItem itemMySQL : orderDomain.getOrderItems()) {
      orderItemMySQLS.add(OrderItemMySQL.fromDomain(itemMySQL));
    }

    return new OrderMySQL(orderDomain.getName(), orderItemMySQLS);
  }

  public static Order toDomain(OrderMySQL orderMySQL) {
    List<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemMySQL orderItemMySQL : orderMySQL.getOrderItems()) {
      orderItems.add(OrderItemMySQL.toDomain(orderItemMySQL));
    }
    return new Order(orderMySQL.getId(), orderMySQL.getName(), orderItems);
  }
}
