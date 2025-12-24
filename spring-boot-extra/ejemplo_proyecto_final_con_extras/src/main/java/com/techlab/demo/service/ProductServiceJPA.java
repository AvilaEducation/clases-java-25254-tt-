package com.techlab.demo.service;

import com.techlab.demo.exception.NotFoundException;
import com.techlab.demo.exception.TechlabCheckedException;
import com.techlab.demo.exception.ValidationException;
import com.techlab.demo.model.entity.Producto;
import com.techlab.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

// beans
@Service
public class ProductServiceJPA implements ProductService {

  //private ProductoMemRepository repository;
  private ProductRepository productoRepository;

  public ProductServiceJPA(ProductRepository repository) {
    this.productoRepository = repository;
  }

  public Producto crearProducto(Producto producto) {
    System.out.println("Creando Nuevo Producto");

    Integer error = 0 / 0;

    return this.productoRepository.guardarProducto(producto);
  }

  //@Transactional
  public List<Producto> listarProductos(String nombre, Double precio) {
    if (!nombre.isEmpty() && precio > 0) {
      return this.productoRepository.obtenerProductosPorNombreYPrecio(nombre, precio);
    }

    if (!nombre.isEmpty()) {
      return this.productoRepository.obtenerProductosPorNombre(nombre);
    }

    if (precio > 0) {
      return this.productoRepository.obtenerProductosPorPrecio(precio);
    }

    return this.productoRepository.obtenerProductos();
  }

  public Producto editarNombreProducto(Long id, Producto dataProducto) {
    // TODO: https://www.baeldung.com/java-optional-return
    Producto producto = this.productoRepository.buscarProductoPorId(id)
        .orElseThrow(() -> new NotFoundException("no encontramos el producto"));

    // VALIDACIONES
    if (dataProducto.getNombre() == null || dataProducto.getNombre().isBlank()) {
      System.out.println("No se puede editar el producto. porque el nombre no es valido");
      throw new ValidationException(
          "No se puede editar el producto. porque el nombre no es valido");
    }

    producto.setNombre(dataProducto.getNombre());
    this.productoRepository.guardarProducto(producto);

    return producto;
  }

  public Producto borrarProducto(Long id) throws TechlabCheckedException {
    Optional<Producto> productOptional = this.productoRepository.buscarProductoPorId(id);
    if (productOptional.isEmpty()) {
      System.out.println("No se puede borrar el producto. porque no se encontro");
      throw new TechlabCheckedException("No se puede borrar el producto. porque no se encontro");
    }

    Producto producto = productOptional.get();

    this.productoRepository.borrarProducto(producto);
    // se puede usar el siguiente codigo, pero hay que manejar una excepcion(OptimisticLockingFailureException)
    //this.repository.deleteById(producto);

    System.out.println("Se borro correctamente el producto con id: " + producto.getId());
    return producto;
  }

}
