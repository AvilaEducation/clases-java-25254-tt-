package clase_07_herencia.practica;

public class Producto {

  private static int nextId = 1;

  private int id;
  private String nombre;
  private int cantidad;
  private double precio;
  private int descuento; // numero del 1 al 100
  private int impuesto; // numero del 1 al 100

  public Producto(String nombre, double precio, int cantidad) {
    this.id = Producto.nextId;
    Producto.nextId++;
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public double calcularPrecioTotal() {
    double total = precio * cantidad;
    logPrecioTotal(total);
    return total;
  }

  protected void logPrecioTotal(double total) {
    System.out.printf("[Producto][calcularPrecioTotal] Nombre: %s - Precio: %s \n", this.nombre,
        total);
  }

  // Getters & Setters
  public int getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(int impuesto) {
    this.impuesto = impuesto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getDescuento() {
    return descuento;
  }

  public void setDescuento(int descuento) {
    this.descuento = descuento;
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

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}
