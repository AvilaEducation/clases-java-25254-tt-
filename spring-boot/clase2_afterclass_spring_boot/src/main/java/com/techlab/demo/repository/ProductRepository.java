package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

  private static int nextId = 1;
  ArrayList<Producto> productos;

  public ProductRepository() {
    this.productos = obtenerProductosTecnologicos();
  }

  public Producto guardarProducto(Producto producto) {
    this.updateId(producto);
    productos.add(producto);
    return producto;
  }

  public ArrayList<Producto> obtenerProductos() {
    return this.productos;
  }

  public ArrayList<Producto> obtenerProductosPorNombreYPrecio(String nombre, int precioTope) {
    ArrayList<Producto> productoEncontrados = new ArrayList<>();
    for (Producto producto : this.productos) {
      if (estaIncluido(producto.getNombre(), nombre) && producto.getPrecio() <= precioTope) {
        productoEncontrados.add(producto);
      }
    }

    return productoEncontrados;
  }

  public ArrayList<Producto> obtenerProductosPorNombre(String nombre) {
    ArrayList<Producto> productoEncontrados = new ArrayList<>();

    for (Producto producto : this.productos) {
      if (estaIncluido(producto.getNombre(), nombre)) {
        productoEncontrados.add(producto);
      }
    }

    return productoEncontrados;
  }

  public ArrayList<Producto> obtenerProductosPorPrecio(int precioTope) {
    ArrayList<Producto> productosFiltrados = new ArrayList<>();

    for (Producto producto : productos) {
      if (producto.getPrecio() <= precioTope) {
        productosFiltrados.add(producto);
      }
    }

    return productosFiltrados;
  }

  public Producto buscarProductoPorId(int id) {
    for (Producto producto : productos) {
      if (producto.getId() == id) {
        return producto;
      }
    }

    return null;
  }

  public Producto borrarProducto(Producto producto) {
    this.productos.remove(producto);
    return producto;
  }

  public void actualizarProducto(Producto producto) {
    System.out.println("se actualizo el producto con id: " + producto.getId());
  }

  // Logica interna del repository
  private boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }

  private String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  private ArrayList<Producto> obtenerProductosTecnologicos() {
    ArrayList<Producto> productos = new ArrayList<>();

    productos.add(new Producto(
        "Laptop Lenovo ThinkPad X1 Carbon",
        1899.99,
        "Ultrabook empresarial de alto rendimiento con diseño liviano y duradero.",
        "Computadoras"));

    productos.add(new Producto(
        "Mouse inalámbrico Logitech MX Master 3",
        99.99,
        "Mouse ergonómico con múltiples botones programables y conectividad Bluetooth.",
        "Accesorios"));

    productos.add(new Producto(
        "Teclado mecánico Razer BlackWidow V4",
        179.99,
        "Teclado gaming mecánico con retroiluminación RGB y teclas programables.",
        "Periféricos"));

    productos.add(new Producto(
        "Monitor LG UltraWide 34 pulgadas",
        499.99,
        "Monitor panorámico con resolución QHD ideal para multitarea y productividad.",
        "Monitores"));

    productos.add(new Producto(
        "Smartphone Samsung Galaxy S23 Ultra",
        1199.99,
        "Teléfono inteligente de gama alta con cámara de 200 MP y pantalla AMOLED.",
        "Smartphones"));

    productos.add(new Producto(
        "Tablet Apple iPad Pro 12.9\"",
        1399.99,
        "Tableta potente con chip M2 y pantalla Liquid Retina XDR.",
        "Tablets"));

    productos.add(new Producto(
        "Disco duro externo Seagate 2TB",
        79.99,
        "Almacenamiento portátil confiable con conectividad USB 3.0.",
        "Almacenamiento"));

    productos.add(new Producto(
        "Memoria RAM Corsair Vengeance 16GB",
        69.99,
        "Módulo de memoria DDR4 ideal para gamers y entusiastas del rendimiento.",
        "Componentes"));

    productos.add(new Producto(
        "Cargador inalámbrico Belkin Boost Up",
        39.99,
        "Base de carga inalámbrica rápida compatible con dispositivos Qi.",
        "Accesorios"));

    productos.add(new Producto(
        "Auriculares Bluetooth Sony WH-1000XM5",
        349.99,
        "Auriculares con cancelación activa de ruido y audio de alta resolución.",
        "Audio"));

    for (Producto producto : productos) {
      this.updateId(producto);
    }

    return productos;
  }

  private void updateId(Producto producto) {
    producto.setId(nextId);
    nextId++;
  }
}
