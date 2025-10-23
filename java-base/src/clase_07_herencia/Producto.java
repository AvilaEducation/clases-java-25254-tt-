package clase_07_herencia;

import java.util.ArrayList;

public class Producto {

  private static int nextId = 1;

  private int id;
  private String nombre;
  private double precio;
  private boolean tieneDescuento;
  private int stock;
  private int cantidad;

  // METODOS ESTATICOS
  public static void mostarListadoProductos(ArrayList<Producto> productos) {
    for (Producto producto : productos) {
      System.out.println(producto.dataConFormato());
    }
  }

  // podemos marcar metodos como abstractos
  public double calcularCostoDeEnvio() {
    return 0;
  }

  // constructor
  public Producto() {

  }

  public Producto(String nombre) {
    this.id = nextId;
    nextId++;
    this.nombre = nombre;
  }

  public Producto(String nombre, double precio) {
    this(nombre);
    this.precio = precio;
    this.tieneDescuento = false;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "cantidad=" + cantidad +
        ", id=" + id +
        ", nombre='" + nombre + '\'' +
        ", precio=" + precio +
        ", tieneDescuento=" + tieneDescuento +
        ", stock=" + stock +
        '}';
  }

  // metodos publicos (botones)
  // getters

  public int getId() {
    return id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public double getPrecio() {
    return this.precio;
  }

  public boolean isTieneDescuento() {
    return this.tieneDescuento;
  }

  // setters
  public void setNombre(String nombre) {
    // la clase producto se encarga de agregar todas las validaciones correspondientes al nombre
    this.nombre = nombre;
  }

  public void setPrecio(double precio) {
    // la clase producto se encarga de agregar todas las validaciones correspondientes al precio
    // por ejemplo, que no se carguen numeros negativos y que el maximo sea 1_000_000
    this.precio = precio;
  }

  public void updateStock(int stockAQuitar) {
    this.stock = stock - stockAQuitar;
  }

  public double calcularTotal() {
    return this.precio * this.cantidad;
  }

  public String dataConFormato() {
    return String.format("ID: %s - Nombre: %s - Precio: %s", this.id, this.nombre, this.precio);
  }

  public boolean coincideId(int id) {
    return this.id == id;
  }

}
