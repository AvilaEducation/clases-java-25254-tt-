package com.techlab.demo.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDomain {

  private Long id;

  private String nombre;
  private double precio;
  private String descripcion;
  private String categoria;
}
