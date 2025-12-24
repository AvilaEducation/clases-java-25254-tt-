package com.techlab.demo.controller;

import com.techlab.demo.exception.TechlabCheckedException;
import com.techlab.demo.model.entity.Producto;
import com.techlab.demo.service.ProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/products")
@CrossOrigin(origins = "FRONT_SERVER")
public class ProductController {

  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping("/products")
  public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.crearProducto(producto));
  }

  // GET /products?nombre="product"&precio=123
  @GetMapping("/products")
  public List<Producto> listarProductos(
      @RequestParam(required = false, defaultValue = "") String nombre,
      @RequestParam(required = false, defaultValue = "0") Double precio) {
    return this.service.listarProductos(nombre, precio);
  }

  //@PatchMapping
  @PutMapping("/products/{id}")
  public Producto editarProducto(@PathVariable Long id, @RequestBody Producto producto) {
    return this.service.editarNombreProducto(id, producto);
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Producto> borrarProducto(@PathVariable(name = "id") Long productId) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(this.service.borrarProducto(productId));
    } catch (TechlabCheckedException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

}
