package clase_06_mas_poo;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Producto teclado = new Producto("teclado programacion", 20.2);
    Producto mouse = new Producto("mouse wireless", 50.2);
    Producto mouse2 = new Producto("mouse wireless", 50.2);
    Producto mouse3 = new Producto("mouse wireless", 50.2);

    ArrayList<Pedido> pedidos = new ArrayList<>();

    Pedido pedido = new Pedido();
    // buscamos y encontramos al teclado, ahora lo usamos para crear un productoCarrito
    ProductoCarrito productoCarrito = new ProductoCarrito(teclado);
    // pedir al usuario la cantidad del producto que va a comprar
    int cantidadAComprar = 2;
    productoCarrito.setCantidad(cantidadAComprar);
    // tenemmos que restar dos al stock del teclado, previa validacion
    teclado.updateStock(cantidadAComprar);

    pedido.agregarProducto(productoCarrito);

    pedidos.add(pedido);

    pedido.listarProductos();

    System.out.println("Total a pagar: " + pedido.calcularPrecioTotal());
  }
}
