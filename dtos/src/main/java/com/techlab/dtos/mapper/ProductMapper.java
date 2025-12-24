package com.techlab.dtos.mapper;

import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.models.dto.ProductDTO;
import com.techlab.dtos.models.dto.response.ProductResponseDTO;

public class ProductMapper {

  public static Product productDTOToDomain(ProductDTO productDTO) {
    return new Product(productDTO.name(), productDTO.description(), productDTO.price(),
        productDTO.stock());
  }

  public static ProductResponseDTO productDomainToResponse(Product product) {
    return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
  }
}
