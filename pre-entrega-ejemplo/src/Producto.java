public class Producto {

  int id;
  String nombre;

  // metodo constructor
  public Producto(int idProducto, String nombreProducto) {
    id = idProducto;
    nombre = nombreProducto;
  }

  public boolean coincideId(int id) {
    return this.id == id;
  }
}
