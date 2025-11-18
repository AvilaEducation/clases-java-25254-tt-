package com.techlab.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private double precio;
  private String descripcion;
  private String categoria;

  // metodo constructor
  public Producto(String nombre, double precio, String descripcion, String categoria) {
    this.nombre = nombre;
    this.precio = precio;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  public Producto() {
  }
}
