package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;

public interface ProductRepository {

  Producto guardarProducto(Producto producto);

  void borrarProducto(Producto producto);
}
