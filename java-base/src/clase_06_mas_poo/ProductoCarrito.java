package clase_06_mas_poo;

public class ProductoCarrito {

  private int id;
  private String nombre;
  private double precio;
  private boolean tieneDescuento;
  private int cantidad;

  public ProductoCarrito(Producto producto) {
    this.setId(producto.getId());
    this.setNombre(producto.getNombre());
    this.setPrecio(producto.getPrecio());
    this.setTieneDescuento(producto.isTieneDescuento());
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

  public boolean isTieneDescuento() {
    return tieneDescuento;
  }

  public void setTieneDescuento(boolean tieneDescuento) {
    this.tieneDescuento = tieneDescuento;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
