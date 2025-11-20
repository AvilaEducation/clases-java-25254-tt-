package com.techlab.demo.service;

import com.techlab.demo.model.Producto;
import java.util.List;

public interface ProductService {

  Producto crearProducto(Producto producto);

  List<Producto> listarProductos(String nombre, Double precio);

  Producto editarNombreProducto(Long id, Producto dataProducto);

  Producto borrarProducto(Long id);
}
