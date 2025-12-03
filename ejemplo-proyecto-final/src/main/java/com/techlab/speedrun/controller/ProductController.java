package com.techlab.speedrun.controller;

import com.techlab.speedrun.entity.Product;
import com.techlab.speedrun.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/products/{id}")
  public Product getProductById(@PathVariable Long id){
    return this.productService.getProductById(id);
  }

  @GetMapping("/products")
  public List<Product> getAllProducts(
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "") String category){
    return this.productService.findAllProducts(name, category);
  }

  @PutMapping("/products/{id}")
  public Product editProductById(@PathVariable Long id, @RequestBody Product dataToEdit){
    return this.productService.editProductById(id, dataToEdit);
  }

  @DeleteMapping("/products/{id}")
  public Product deleteProductById(@PathVariable Long id){
    return this.productService.deleteProductById(id);
  }

}
