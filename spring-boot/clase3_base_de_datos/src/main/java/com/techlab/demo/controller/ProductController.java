package com.techlab.demo.controller;

import com.techlab.demo.entity.Producto;
import com.techlab.demo.repository.ProductRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private ProductRepository repository;

  public ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/productos")
  public Producto crearProducto(@RequestBody Producto producto){
    return this.repository.save(producto);
  }

  @GetMapping("/productos")
  public List<Producto> listarProductos(){
    return this.repository.findAll();
  }
}
