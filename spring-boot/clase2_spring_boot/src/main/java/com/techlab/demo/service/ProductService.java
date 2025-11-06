package com.techlab.demo.service;

import com.techlab.demo.model.Producto;
import com.techlab.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

// beans
@Service
public class ProductService {

  private ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public Producto crearProducto(Producto producto) {
    System.out.println("Creando Nuevo Producto");

    return this.repository.guardarProducto(producto);
  }

//  public static void listarProductos(ArrayList<Producto> productos) {
//    System.out.println(
//        "==============================================================================================");
//    System.out.println(
//        "                                  LISTA DE PRODUCTOS TECNOLÓGICOS                             ");
//    System.out.println(
//        "==============================================================================================");
//
//    if (productos == null || productos.isEmpty()) {
//      System.out.println("⚠️  No hay productos para mostrar.");
//    } else {
//      System.out.printf("| %-3s | %-35s | %-10s | %-20s | %-15s |%n",
//          "ID", "Nombre", "Precio", "Categoría", "Descripción");
//      System.out.println(
//          "----------------------------------------------------------------------------------------------");
//
//      for (Producto producto : productos) {
//        System.out.printf("| %3d | %-35s | $%9.2f | %-20s | %-15s |%n",
//            producto.getId(),
//            producto.getNombre(),
//            producto.getPrecio(),
//            producto.getCategoria(),
//            acortarDescripcion(producto.getDescripcion(), 15));
//      }
//    }
//
//    System.out.println(
//        "==============================================================================================");
//    pausa();
//  }

//  private static String acortarDescripcion(String descripcion, int maxLength) {
//    if (descripcion.length() <= maxLength) {
//      return descripcion;
//    } else {
//      return descripcion.substring(0, maxLength - 3) + "...";
//    }
//  }
//
//
//  public static void buscarProductoPorNombre(ArrayList<Producto> productos) {
//    System.out.println("Ingrese un nombre de un producto: ");
//    String busqueda = entrada.nextLine();
//    ArrayList<Producto> productoEncontrados = new ArrayList<>();
//
//    for (Producto producto : productos) {
//      if (estaIncluido(producto.getNombre(), busqueda)) {
//        productoEncontrados.add(producto);
//      }
//    }
//
//    listarProductos(productoEncontrados);
//  }
//
//  public static void editarProducto(List<Producto> productos) {
//    // el listado de productos tiene las direcciones de memoria de los productos originales
//    // aca obtenemos la direccion de memoria que nos permite modificar el objeto original
//    // que es uno de los que esta en el listado
//    Producto producto = obtenerProductoPorId(productos);
//    // TODO: validar que encontramos el producto
//    if (producto == null) {
//      System.out.println("No se puede editar el producto.");
//      pausa();
//      return; // cuando hacemos el return en una funcion void, estamos cortando la ejecucion de la funcion
//    }
//
//    String nombreOriginal = producto.getNombre();
//    System.out.println("Producto a editar:");
//    System.out.println(nombreOriginal);
//    // TODO: validar que el usuario quiere editar el producto que se encontro
//    System.out.print("Ingrese el nuevo nombre: ");
//    String nuevoNombre = entrada.nextLine();
//
//    // ["p1", "p2", "p3"]
//    // set(1, "p38")
//    // ["p1", "p38", "p3"]
//    // actualizamos el nombre en el producto
//    producto.setNombre(nuevoNombre);
//
//    System.out.printf("El nombre del producto cambio de %s a %s", nombreOriginal, nuevoNombre);
//  }
//
//  public static void borrarProducto(List<Producto> productos) {
//    Producto producto = obtenerProductoPorId(productos);
//    // TODO: validar que encontramos el producto
//    if (producto == null) {
//      System.out.println("No pudimos borrar el producto");
//      pausa();
//      return; //
//    }
//    String nombreOriginal = producto.getNombre();
//    System.out.println("Producto a borrar:");
//    System.out.println(nombreOriginal);
//    // TODO: validar que el usuario quiere borrar el producto que se encontro
//
//    // aca borramos el producto
//    productos.remove(producto);
//    System.out.println("Borrado exitosamente!");
//  }
//
//  public static void filtroPorPrecio(List<Producto> productos) {
//    double precioFiltro = entrada.nextDouble();
//
//    ArrayList<Producto> productosFiltrados = new ArrayList<>();
//
//    for (Producto producto : productos) {
//      if (producto.getPrecio() <= precioFiltro) {
//        productosFiltrados.add(producto);
//      }
//    }
//
//    listarProductos(productosFiltrados);
//  }
//
//  /* UTILIDADES */
//  /* Busqueda por id - ahora mismo solo funciona con el indice, en el futuro se va a cambiar */
//  public static Producto obtenerProductoPorId(List<Producto> productos) {
//    // TODO: validacion de datos
//    System.out.println("Ingrese el id del producto: ");
//    int idBusqueda = entrada.nextInt();
//
//    for (Producto producto : productos) {
//      if (producto.coincideId(idBusqueda)) {
//        return producto;
//      }
//    }
//
//    System.out.println("No pudimos encontrar el producto con el id: " + idBusqueda);
//    return null; // el null representa que no encontramos el producto
//  }
//
//  public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
//    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
//
//    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
//  }
//
//  public static String formatoBusqueda(String texto) {
//    return texto.trim().toLowerCase();
//  }
//
//  public static void pausa() {
//    System.out.println("Pulse ENTER para continuar...");
//    entrada = new Scanner(System.in);
//    entrada.nextLine();
//    for (int i = 0; i < 20; ++i) {
//      System.out.println();
//    }
//    // TODO: limpiar la pantalla de la consola
//  }
}
