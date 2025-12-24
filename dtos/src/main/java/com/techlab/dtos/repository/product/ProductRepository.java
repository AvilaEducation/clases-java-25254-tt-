package com.techlab.dtos.repository.product;

import com.techlab.dtos.models.domain.Product;
import java.util.List;

public interface ProductRepository {

  Product createProduct(Product product);

  List<Product> getProductsByIds(List<Long> productIds);

  Product getProductById(Long id);

  List<Product> getProducts(String name);

  Product updateProduct(Product product);

  Product deleteProduct(Long id);
}
