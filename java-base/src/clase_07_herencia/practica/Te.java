package clase_07_herencia.practica;

public class Te extends Producto {

  private static final int DESCUENTO_POR_TE = 5;
  private static final int IMPUESTO_IVA = 10;
  private static final int IMPUESTO_IMPORTACION = 9;


  public Te(String nombre, double precio, int cantidad) {
    super(nombre, precio, cantidad);
    setImpuesto(IMPUESTO_IVA + IMPUESTO_IMPORTACION);
    setDescuento(DESCUENTO_POR_TE);
  }

  @Override
  public double calcularPrecioTotal() {
    double total = this.getPrecio() * this.getCantidad();
    double impuesto = total * ((double) getImpuesto() / 100);
    double descuento = total * ((double) getDescuento() / 100);

    total = total - descuento + impuesto;
    logPrecioTotal(total);

    return total;
  }

  @Override
  protected void logPrecioTotal(double total) {
    System.out.printf("[Te][calcularPrecioTotal] Nombre: %s - Precio: %s \n",
        this.getNombre(),
        total);
  }
}
