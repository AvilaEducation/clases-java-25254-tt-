package clase05_poo;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    int numero = 1283;

    String nomrbe = "laksjd";

    Producto teclado = new Producto(2, "teclado programacion", 20.2);

    System.out.println(teclado.id);

    Producto mouse = new Producto(1, "mouse wireless", 50.2);

    System.out.println(mouse.id);

    ArrayList<Producto> productos = new ArrayList<>();
  }
}