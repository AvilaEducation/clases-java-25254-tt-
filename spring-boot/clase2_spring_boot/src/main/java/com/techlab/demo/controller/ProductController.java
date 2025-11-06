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

  // localhost:8080/hello
  @GetMapping("/hello")
  public String helloWorld() {
    return "Hola comision 25254";
  }

  @PostMapping("/products")
  public Producto crearProducto(@RequestBody Producto producto) {
    return this.service.crearProducto(producto);
  }

  // ArrayList
  // TODO: fix
  // GET /products
  // GET /products?nombre="akjshd"
  // GET /products?nombre="product"&precio=123
  @GetMapping("/products")
  public List<String> listarProductos(
      @RequestParam(required = false, defaultValue = "") String nombre, @RequestParam int precio) {
    return List.of(nombre, String.valueOf(precio));
  }

  // TODO: fix
  @GetMapping("/products/nombre")
  public List<String> buscarProductoPorNombre(@RequestParam String nombre) {
    return List.of("producto1", nombre);
  }

  @GetMapping("/products/precio")
  public List<String> buscarProductoPorPrecio(@RequestParam int precio) {
    return List.of("producto1", String.valueOf(precio));
  }

  // PUT /products/12
  // PUT /products/13
  // PUT /products/23
  // PUT /products/aksldjas
  //@PatchMapping
  @PutMapping("/products/{id}")
  public String editarProducto(@PathVariable int id) {
    return "editando producto" + id;
  }

  @DeleteMapping("/products/{id}")
  public String borrarProducto(@PathVariable(name = "id") int productId) {
    return "borrando producto" + productId;
  }

  // POST   /products
  // GET    /products
  // PUT    /products/12
  // DELETE /products/15

  // POST, PUT & PATCH
//case 1 -> crearProducto(productosDB);

//case 2 -> listarProductos(productosDB);
//case 3 -> buscarProductoPorNombre(productosDB);
  //case 6 -> filtroPorPrecio(productosDB);

//case 4 -> editarProducto(productosDB);
//case 5 -> borrarProducto(productosDB);
}
