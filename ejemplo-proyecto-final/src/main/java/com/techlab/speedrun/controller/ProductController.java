package com.techlab.speedrun.controller;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/products")
  public Product createProduct(@RequestBody Product product){
    return this.productService.createProduct(product);
  }
}
