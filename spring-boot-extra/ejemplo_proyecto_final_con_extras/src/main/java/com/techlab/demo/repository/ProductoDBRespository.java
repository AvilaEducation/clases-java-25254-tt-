package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ProductoDBRespository implements ProductRepository {

  private ProductoRepositoryJPA productoRepositoryJPA;

  public ProductoDBRespository(ProductoRepositoryJPA productoRepositoryJPA) {
    this.productoRepositoryJPA = productoRepositoryJPA;
  }

  @Override
  public Producto guardarProducto(Producto producto) {
    return this.productoRepositoryJPA.save(producto);
  }

  @Override
  public void borrarProducto(Producto producto) {
    this.productoRepositoryJPA.delete(producto);
  }
}
