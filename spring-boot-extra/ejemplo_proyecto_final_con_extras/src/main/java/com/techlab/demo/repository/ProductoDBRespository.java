package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("local")
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

  @Override
  public Optional<Producto> buscarProductoPorId(Long id) {
    return this.productoRepositoryJPA.findById(id);
  }

  @Override
  public List<Producto> obtenerProductos() {
    return this.productoRepositoryJPA.findAll();
  }

  @Override
  public List<Producto> obtenerProductosPorNombre(String nombre) {
    return this.productoRepositoryJPA.findByNombreContaining(nombre);
  }

  @Override
  public List<Producto> obtenerProductosPorPrecio(Double precio) {
    return this.productoRepositoryJPA.findByPrecioLessThanEqual(precio);
  }

  @Override
  public List<Producto> obtenerProductosPorNombreYPrecio(String nombre, Double precio) {
    return this.productoRepositoryJPA.findByNombreContainingAndPrecioLessThanEqual(nombre, precio);
  }
}
