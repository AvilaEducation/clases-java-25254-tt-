package com.techlab.dtos.controller;

import com.techlab.dtos.mapper.ProductMapper;
import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.models.dto.ProductDTO;
import com.techlab.dtos.models.dto.response.ProductResponseDTO;
import com.techlab.dtos.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/products")
  public ProductResponseDTO addProduct(@RequestBody ProductDTO product) {
    Product productToSave = ProductMapper.productDTOToDomain(product);
    Product productSaved = productService.createProduct(productToSave);
    return ProductMapper.productDomainToResponse(productSaved);
  }
}
