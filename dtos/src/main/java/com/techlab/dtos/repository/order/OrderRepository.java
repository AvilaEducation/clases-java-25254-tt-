package com.techlab.dtos.repository.order;


import com.techlab.dtos.models.domain.Order;

public interface OrderRepository {

  Order createOrder(Order order);
}
