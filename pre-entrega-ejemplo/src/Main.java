import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<String> productosDB = obtenerProductosTecnologicos();
    int opcionUsuario;

    System.out.println("Te damos la bienvenida a la app de compras 🛒");
    label:
    while (true) {
      System.out.println("""
          Ingrese el número equivalente a la opción:
          0 - Finaliza el programa
          1 - Crea un Producto
          2 - Listar Productos
          3 - Búsqueda por nombre
          4 - Editar nombre producto
          5 - Borrar producto
          """);
      opcionUsuario = entrada.nextInt();

      switch (opcionUsuario) {
        case 1 -> crearProducto(productosDB); // - >
        case 2 -> listarProductos(productosDB);
        case 3 -> buscarProductoPorNombre(productosDB);
        case 0 -> {
          System.out.println("Gracias por usar la app!");
          break label; // corta el bucle donde se ejecuta
        }
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }
  }

  public static void crearProducto(ArrayList<String> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Nuevo Producto");
    System.out.print("Ingrese el nombre del nuevo producto: ");
    String nombre = entrada.nextLine();

    productos.add(nombre);

    // TODO: agregar un mensaje de confirmación cuando se crea el producto
    pausa();
  }

  public static void listarProductos(ArrayList<String> productos) {
    System.out.println("=======================================");
    System.out.println("        LISTA DE PRODUCTOS");
    System.out.println("=======================================");

    if (productos == null || productos.isEmpty()) {
      System.out.println("⚠️  No hay productos para mostrar.");
    } else {
      int contador = 1;
      for (String producto : productos) {
        System.out.printf(" %2d. %s%n", contador++, producto);
      }
    }

    System.out.println("=======================================");
    pausa();
  }

  public static void buscarProductoPorNombre(ArrayList<String> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese un nombre de un producto: ");
    String busqueda = entrada.nextLine();
    ArrayList<String> productoEncontrados = new ArrayList<>();

    for (String producto : productos) {
      if (estaIncluido(producto, busqueda)) {
        productoEncontrados.add(producto);
      }
    }

    listarProductos(productoEncontrados);
  }

  /* UTILIDADES */
  public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
    String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

    return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
  }

  public static String formatoBusqueda(String texto) {
    return texto.trim().toLowerCase();
  }

  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
    // TODO: limpiar la pantalla de la consola
  }

  public static ArrayList<String> obtenerProductosTecnologicos() {
    ArrayList<String> productos = new ArrayList<>();

    productos.add("Laptop Lenovo ThinkPad X1 Carbon");
    productos.add("Mouse inalámbrico Logitech MX Master 3");
    productos.add("Teclado mecánico Razer BlackWidow V4");
    productos.add("Monitor LG UltraWide 34 pulgadas");
    productos.add("Smartphone Samsung Galaxy S23 Ultra");
    productos.add("Tablet Apple iPad Pro 12.9\"");
    productos.add("Disco duro externo Seagate 2TB");
    productos.add("Memoria RAM Corsair Vengeance 16GB");
    productos.add("Cargador inalámbrico Belkin Boost Up");
    productos.add("Auriculares Bluetooth Sony WH-1000XM5");

    return productos;
  }
}
