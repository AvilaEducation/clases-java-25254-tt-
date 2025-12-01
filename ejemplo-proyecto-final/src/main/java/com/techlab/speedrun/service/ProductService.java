package com.techlab.speedrun.service;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
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

  public Product getProductById(Long id){
    Optional<Product> productOptional = this.productRepository.findById(id);

    if (productOptional.isEmpty()){
      throw new RuntimeException("Producto no encontrado con ID: " + id);
    }

    return productOptional.get();
  }

  public List<Product> findAllProducts(String name, String category){
    if (!name.isEmpty() && !category.isEmpty()){
      return this.productRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
    }

    if (!name.isEmpty()){
      return this.productRepository.findByNameContainingIgnoreCase(name);
    }

    if (!category.isEmpty()){
      return this.productRepository.findByCategoryContainingIgnoreCase(category);
    }

    return this.productRepository.findAll();
  }
}
