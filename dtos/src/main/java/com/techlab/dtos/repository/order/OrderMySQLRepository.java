package com.techlab.dtos.repository.order;

import com.techlab.dtos.models.domain.Order;
import com.techlab.dtos.models.entity.OrderMySQL;
import org.springframework.stereotype.Repository;

@Repository
public class OrderMySQLRepository implements OrderRepository {

  private OrderJPARepository orderJPARepository;

  public OrderMySQLRepository(OrderJPARepository orderJPARepository) {
    this.orderJPARepository = orderJPARepository;
  }

  @Override
  public Order createOrder(Order order) {
    OrderMySQL orderMySQL = orderJPARepository.save(OrderMySQL.fromDomain(order));

    return OrderMySQL.toDomain(orderMySQL);
  }
}
