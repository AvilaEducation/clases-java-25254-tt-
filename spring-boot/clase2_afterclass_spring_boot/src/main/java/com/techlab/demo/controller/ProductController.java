package com.techlab.demo.controller;

import com.techlab.demo.model.Producto;
import com.techlab.demo.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping("/products")
  public Producto crearProducto(@RequestBody Producto producto) {
    return this.service.crearProducto(producto);
  }

  // TODO: ver wrappers
  // TODO: preguntar a sofi sobre las inscripciones del 2026
  // GET /products?nombre="product"&precio=123
  @GetMapping("/products")
  public List<Producto> listarProductos(
      @RequestParam(required = false, defaultValue = "") String nombre,
      @RequestParam(required = false, defaultValue = "0") int precio) {
    return this.service.listarProductos(nombre, precio);
  }

  //@PatchMapping
  @PutMapping("/products/{id}")
  public Producto editarProducto(@PathVariable int id, @RequestBody Producto producto) {
    return this.service.editarNombreProducto(id, producto);
  }

  @DeleteMapping("/products/{id}")
  public Producto borrarProducto(@PathVariable(name = "id") int productId) {
    return this.service.borrarProducto(productId);
  }

}
