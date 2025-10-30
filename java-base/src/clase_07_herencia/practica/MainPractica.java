package clase_07_herencia.practica;

import java.util.ArrayList;

public class MainPractica {

  public static void main(String[] args) {
    ArrayList<Producto> productos = productosEjemplos();

    double totalAPagar = 0;
    for (Producto producto : productos) {
      totalAPagar += producto.calcularPrecioTotal();
    }

    System.out.println("Total a Pagar es: " + totalAPagar + "$");
  }

  public static ArrayList<Producto> productosEjemplos() {
    ArrayList<Producto> productos = new ArrayList<>();

    productos.add(new Producto("p1", 1000, 2));
    productos.add(new Cafe("c1", 100, 1));
    productos.add(new Te("t1", 100, 1));

    return productos;
  }
}
