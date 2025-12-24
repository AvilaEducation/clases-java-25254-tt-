package com.techlab.dtos.mapper;

import com.techlab.dtos.models.domain.Order;
import com.techlab.dtos.models.domain.OrderItem;
import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.models.dto.OrderDTO;
import com.techlab.dtos.models.dto.OrderItemDTO;
import com.techlab.dtos.models.dto.response.OrderResponseDTO;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

  public static Order orderDomainFromDTO(OrderDTO orderDTO) {
    List<OrderItem> items = new ArrayList<>();
    for (OrderItemDTO itemDTO : orderDTO.items()) {
      Product product = new Product(itemDTO.productId());
      OrderItem item = new OrderItem(product, itemDTO.amount());
      items.add(item);
    }

    return new Order(orderDTO.name(), items);
  }

  public static OrderResponseDTO orderResponseFromDomain(Order order) {
    return new OrderResponseDTO(order.getId(), order.getName(), order.getTotalPrice());
  }
}
