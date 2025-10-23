package clase_07_herencia;

public class ProductoComestible extends Producto {

  double descuento;
  String fechaVencimiento;
  private double peso;

  public String nuevoMetodo() {
    return "aslkjda";
  }

  @Override
  public String toString() {
    return "Nombre: " + this.getNombre() + this.nuevoMetodo() + this.fechaVencimiento;
  }

  @Override
  public double calcularTotal() {
    return super.calcularTotal() * this.descuento;
  }

  @Override
  public double calcularCostoDeEnvio() {
    return peso;
  }
}
