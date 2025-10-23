public class Producto {

  private static int nextId = 1;

  private int id;
  private String nombre;
  private double precio;
  private String descripcion;
  private String categoria;

  // metodo constructor
  public Producto(String nombre, double precio, String descripcion, String categoria) {
    this.id = Producto.nextId;
    Producto.nextId++;
    this.nombre = nombre;
    this.precio = precio;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  // getter & setters

  public int getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    if (precio <= 0) {
      System.out.println("El precio debe ser mayor a cero, no se modifico nada");
      return;
    }
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    if (descripcion.length() > 500) {
      System.out.println("El limite de caracteres es 500, no se modifico la descripcion");
      return;
    }
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public boolean coincideId(int id) {
    return this.id == id;
  }
}
