package com.techlab.dtos.controller;

import com.techlab.dtos.mapper.OrderMapper;
import com.techlab.dtos.models.domain.Order;
import com.techlab.dtos.models.dto.OrderDTO;
import com.techlab.dtos.models.dto.response.OrderResponseDTO;
import com.techlab.dtos.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/orders")
  public OrderResponseDTO createOrder(@RequestBody OrderDTO orderRequest) {
    Order orderToSave = OrderMapper.orderDomainFromDTO(orderRequest);
    Order order = orderService.createOrder(orderToSave);
    return OrderMapper.orderResponseFromDomain(order);
  }
}
