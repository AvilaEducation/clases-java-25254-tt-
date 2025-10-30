package com.techlab.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  // POST   /products
  // GET    /products
  // PUT    /products/12
  // DELETE /products/15

  // localhost:8080/hello
  @GetMapping("/hello")
  public String helloWorld(){
    return "Hola comision 25254";
  }

  // POST, PUT & PATCH

}
