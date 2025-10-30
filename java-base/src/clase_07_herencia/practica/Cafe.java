package clase_07_herencia.practica;

public class Cafe extends Producto {

  private int percepciones; // numero del 1 al 100

  public Cafe(String nombre, double precio, int cantidad) {
    super(nombre, precio, cantidad);
    setImpuesto(21);
    setDescuento(10);
    setPercepciones(10);
  }

  @Override
  public double calcularPrecioTotal() {
    double total = this.getPrecio() * this.getCantidad();
    double impuesto = total * ((double) getImpuesto() / 100);
    double descuento = total * ((double) getDescuento() / 100);
    double percepciones = (total + impuesto) * ((double) this.percepciones / 100);

    total = total - descuento + percepciones + impuesto;
    logPrecioTotal(total);

    return total;
  }

  @Override
  protected void logPrecioTotal(double total) {
    System.out.printf("[Cafe][calcularPrecioTotal] Nombre: %s - Precio: %s \n",
        this.getNombre(),
        total);
  }

  public void setPercepciones(int percepciones) {
    this.percepciones = percepciones;
  }
}
