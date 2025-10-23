package clase_07_herencia;

import java.util.ArrayList;

public class Main {

  // TODO: ver ejemplos de modificadores de acceso
  public static void main(String[] args) {
    Object o = new Object();
    ProductoComestible pan = new ProductoComestible();
    ProductoComestible yogurt = pan;
    Producto producto = new Producto("no es pan");

    pan.setNombre("pan lactal");
    pan.setPrecio(123);

//    System.out.println(pan.getNombre());
//    System.out.println(pan.getPrecio());
//    System.out.println(o);
//    System.out.println(pan.toString());
////    System.out.println(pan.equals(yogurt));
//    System.out.println(producto);

    // ejemplo de casteo
    double numeritoFlotante = 123.123;
    int numerito = (int) numeritoFlotante;
    double masNumeritoQueNunca = numerito;

    ArrayList<Producto> productos = new ArrayList<>();
    productos.add(producto);
    productos.add(pan);

    for (Producto product : productos) {
      double descuento = product.calcularTotal();
      double costoEnvio = product.calcularCostoDeEnvio();

      System.out.println(product.toString());
    }
  }
}
