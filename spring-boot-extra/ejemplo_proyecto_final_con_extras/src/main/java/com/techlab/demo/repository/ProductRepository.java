package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  Producto guardarProducto(Producto producto);

  void borrarProducto(Producto producto);

  Optional<Producto> buscarProductoPorId(Long id);

  List<Producto> obtenerProductos();

  List<Producto> obtenerProductosPorNombre(String nombre);

  List<Producto> obtenerProductosPorPrecio(Double precio);

  List<Producto> obtenerProductosPorNombreYPrecio(String nombre, Double precio);
}
