package com.techlab.dtos.repository.product;

import com.techlab.dtos.models.domain.Product;
import com.techlab.dtos.models.entity.ProductMySQL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductMySQLRepository implements ProductRepository {

  private ProductJPARepository productJPARepository;

  public ProductMySQLRepository(ProductJPARepository productJPARepository) {
    this.productJPARepository = productJPARepository;
  }

  @Override
  public Product createProduct(Product product) {
    ProductMySQL productMySQL = ProductMySQL.fromProductDomain(product);
    productMySQL = productJPARepository.save(productMySQL);
    product.setId(productMySQL.getId());

    return product;
  }

  @Override
  public List<Product> getProductsByIds(List<Long> productIds) {
    List<Product> products = new ArrayList<>();
    List<ProductMySQL> productMySQLs = productJPARepository.findAllById(productIds);
    for (ProductMySQL productMySQL : productMySQLs) {
      products.add(ProductMySQL.toDomain(productMySQL));
    }

    return products;
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
    return null;
  }

  @Override
  public Product deleteProduct(Long id) {
    return null;
  }
}
