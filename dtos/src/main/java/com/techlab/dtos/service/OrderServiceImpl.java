package com.techlab.dtos.service;

import com.techlab.dtos.models.domain.Order;
import com.techlab.dtos.models.domain.OrderItem;
import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.repository.order.OrderRepository;
import com.techlab.dtos.utils.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;

  private ProductService productService;

  public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
    this.orderRepository = orderRepository;
    this.productService = productService;
  }

  @Override
  @Transactional
  public Order createOrder(Order order) {
    List<Product> products = productService.getProductsByIds(order.getProductIds());
    HashMap<Long, Product> productMap = CollectionUtils.listToMap(products);

    // Validated stock and update items
    for (OrderItem item : order.getOrderItems()) {
      Product product = productMap.get(item.getProductId());
      if (item.getAmount() > product.getStock()) {
        throw new RuntimeException("unsufficient stock");
      }

      product.setStock(product.getStock() - item.getAmount());
      productService.updateProduct(product);
      item.setProduct(product);
    }

    return orderRepository.createOrder(order);
  }
}
