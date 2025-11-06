package com.techlab.demo.model;

public class Producto {

  private int id;
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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}
