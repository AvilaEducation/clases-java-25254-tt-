package com.techlab.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ItemCarrito {

  @Id
  private Long id;

  private Integer cantidadAComprar;

  @OneToOne
  @ManyToOne
  private Producto producto;
}
