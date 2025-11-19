package com.techlab.demo.service;

import com.techlab.demo.model.Producto;
import com.techlab.demo.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

// beans
@Service
public class ProductService {

  //private ProductoMemRepository repository;
  private ProductoRepository productoRepository;

  public ProductService(ProductoRepository repository) {
    this.productoRepository = repository;
  }

  public Producto crearProducto(Producto producto) {
    System.out.println("Creando Nuevo Producto");

    return this.productoRepository.save(producto);
  }

  public List<Producto> listarProductos(String nombre, Double precio) {
    if (!nombre.isEmpty() && precio > 0) {
      return this.productoRepository.findByNombreContainingAndPrecioLessThanEqual(nombre, precio);
    }

    if (!nombre.isEmpty()) {
      return this.productoRepository.findByNombreContaining(nombre);
    }

    if (precio > 0) {
      return this.productoRepository.findByPrecioLessThanEqual(precio);
    }

    return this.productoRepository.findAll();
  }

  public Producto editarNombreProducto(Long id, Producto dataProducto) {
    // TODO: https://www.baeldung.com/java-optional-return
    Producto producto = this.productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("no encontramos el producto"));

    // VALIDACIONES
    if (dataProducto.getNombre() == null || dataProducto.getNombre().isBlank()) {
      System.out.println("No se puede editar el producto. porque el nombre no es valido");
      return null;
    }

    producto.setNombre(dataProducto.getNombre());
    this.productoRepository.save(producto);

    return producto;
  }

  public Producto borrarProducto(Long id) {
    Optional<Producto> productOptional = this.productoRepository.findById(id);
    if (productOptional.isEmpty()) {
      System.out.println("No se puede borrar el producto. porque no se encontro");
      return null;
    }

    Producto producto = productOptional.get();

    this.productoRepository.delete(producto);
    // se puede usar el siguiente codigo, pero hay que manejar una excepcion(OptimisticLockingFailureException)
    //this.repository.deleteById(producto);

    System.out.println("Se borro correctamente el producto con id: " + producto.getId());
    return producto;
  }
}
