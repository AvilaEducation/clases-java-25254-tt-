package clase_07_herencia;

public class ProductoIndumentaría extends Producto {

  private double peso;

  @Override
  public double calcularCostoDeEnvio() {
    return peso;
  }
}
