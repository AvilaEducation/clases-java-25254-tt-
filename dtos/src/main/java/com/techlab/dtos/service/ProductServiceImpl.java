package com.techlab.dtos.service;

import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.repository.product.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.createProduct(product);
  }

  @Override
  public List<Product> getProductsByIds(List<Long> productIds) {
    return productRepository.getProductsByIds(productIds);
  }

  @Override
  public Product getProductById(Long id) {
    return null;
  }

  @Override
  public List<Product> getProducts(String name) {
    return List.of();
  }

  @Override
  public Product updateProduct(Product product) {
    return productRepository.createProduct(product);
  }

  @Override
  public Product deleteProduct(Long id) {
    return null;
  }
}
