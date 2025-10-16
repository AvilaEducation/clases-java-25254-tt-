package clase_06_mas_poo;

import java.util.ArrayList;

public class Pedido {

  private ArrayList<ProductoCarrito> productos;

  public Pedido() {
    productos = new ArrayList<>();
  }

  public void agregarProducto(ProductoCarrito producto) {
    productos.add(producto);
  }

  public double calcularPrecioTotal() {
    if (productos.isEmpty()) {
      return 0;
    }

    double total = 0;
    for (ProductoCarrito producto : productos) {
      total += producto.getPrecio();
    }

    return total;
  }

  public void listarProductos() {
    for (ProductoCarrito producto : productos) {
      System.out.println(producto.getNombre());
    }
  }

  public int getContadorProductos() {
    return productos.size();
  }
}
