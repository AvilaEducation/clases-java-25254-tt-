package com.techlab.speedrun.service;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(Product product){
    System.out.println("Producto ingresado: " + product);

    // productSavedWithId
    return this.productRepository.save(product);
  }
}
