package clase05_poo;

public class Producto {

  int id;
  String nombre;
  double precio;
  boolean tieneDescuento;

  // constructor
  public Producto() {

  }

  public Producto(int idProducto, String nombreProducto, double precioProducto) {
    id = idProducto;
    nombre = nombreProducto;
    precio = precioProducto;
    tieneDescuento = false;
  }

}
