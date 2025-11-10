package com.techlab.demo.service;

import com.techlab.demo.model.Producto;
import com.techlab.demo.repository.ProductRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

// beans
@Service
public class ProductService {

  private ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Producto crearProducto(Producto producto) {
    System.out.println("Creando Nuevo Producto");

    return this.repository.guardarProducto(producto);
  }

  public ArrayList<Producto> listarProductos(String nombre, int precio) {
    if (!nombre.isEmpty() && precio > 0) {
      return this.repository.obtenerProductosPorNombreYPrecio(nombre, precio);
    }

    if (!nombre.isEmpty()) {
      return this.repository.obtenerProductosPorNombre(nombre);
    }

    if (precio > 0) {
      return this.repository.obtenerProductosPorPrecio(precio);
    }

    return this.repository.obtenerProductos();
  }


  public Producto editarNombreProducto(int id, Producto dataProducto) {
    Producto producto = this.repository.buscarProductoPorId(id);
    if (producto == null) {
      System.out.println("No se puede editar el producto. porque no se encontro el producto");
      return null;
    }

    // VALIDACIONES
    if (dataProducto.getNombre() == null || dataProducto.getNombre().isBlank()) {
      System.out.println("No se puede editar el producto. porque el nombre no es valido");
      return null;
    }

    producto.setNombre(dataProducto.getNombre());
    this.repository.actualizarProducto(producto);

    return producto;
  }

  public Producto borrarProducto(int id) {
    Producto producto = this.repository.buscarProductoPorId(id);
    if (producto == null) {
      System.out.println("No se puede borrar el producto. porque no se encontro");
      return null;
    }

    producto = this.repository.borrarProducto(producto);

    System.out.println("Se borro correctamente el producto con id: " + producto.getId());
    return producto;
  }
}
