package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoryJPA extends JpaRepository<Producto, Long> {

  // TODO: query methods: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  List<Producto> searchByNombre(String nombre);

  List<Producto> findByNombreContaining(String nombre);

  List<Producto> findByPrecioLessThanEqual(Double precio);

  List<Producto> findByNombreContainingAndPrecioLessThanEqual(String nombre, Double precio);
}
