package com.techlab.model;

public class Song {

  // ESTO DEBERIA ESTAR EN OTRA CAPA (repository/database)
  private static int nextId = 1;

  private int id;
  private String nombre;
  private String descripcion;
  private int duracion;

  public Song() {
  }

  public Song(String nombre, String descripcion, int duracion) {
    this.addId();
    this.descripcion = descripcion;
    this.duracion = duracion;
    this.nombre = nombre;
  }

  public void addId() {
    this.id = nextId;
    nextId++;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
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
}
