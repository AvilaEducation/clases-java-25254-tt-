import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Producto> productosDB = obtenerProductosTecnologicos();
    int idSiguiente = productosDB.size() + 1;
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
          6 - nueva funcion
          """);
      opcionUsuario = entrada.nextInt();

      switch (opcionUsuario) {
        case 1 -> {
          crearProducto(idSiguiente, productosDB);
          idSiguiente += 1;
        }
        case 2 -> listarProductos(productosDB);
        case 3 -> buscarProductoPorNombre(productosDB);
        case 4 -> editarProducto(productosDB);
        case 5 -> borrarProducto(productosDB);
        case 6 -> System.out.println("Funcionalida en progreso...");
        case 0 -> {
          System.out.println("Gracias por usar la app!");
          break label; // corta el bucle donde se ejecuta
        }
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }
  }

  public static void crearProducto(int id, ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Creando Nuevo Producto");
    System.out.print("Ingrese el nombre del nuevo producto: ");
    String nombre = entrada.nextLine();

    // TODO: cambiarlo cuando veamos static
    productos.add(new Producto(id, nombre));

    // TODO: agregar un mensaje de confirmación cuando se crea el producto
    pausa();
  }

  public static void listarProductos(ArrayList<Producto> productos) {
    System.out.println("=======================================");
    System.out.println("        LISTA DE PRODUCTOS");
    System.out.println("=======================================");

    if (productos == null || productos.isEmpty()) {
      System.out.println("⚠️  No hay productos para mostrar.");
    } else {
      for (Producto producto : productos) {
        System.out.printf(" %2d. %s%n", producto.id, producto.nombre);
      }
    }

    System.out.println("=======================================");
    pausa();
  }

  public static void buscarProductoPorNombre(ArrayList<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingrese un nombre de un producto: ");
    String busqueda = entrada.nextLine();
    ArrayList<Producto> productoEncontrados = new ArrayList<>();

    for (Producto producto : productos) {
      if (estaIncluido(producto.nombre, busqueda)) {
        productoEncontrados.add(producto);
      }
    }

    listarProductos(productoEncontrados);
  }

  public static void editarProducto(List<Producto> productos) {
    // el listado de productos tiene las direcciones de memoria de los productos originales
    Scanner entrada = new Scanner(System.in);
    // aca obtenemos la direccion de memoria que nos permite modificar el objeto original
    // que es uno de los que esta en el listado
    Producto producto = obtenerProductoPorId(productos);
    // TODO: validar que encontramos el producto
    String nombreOriginal = producto.nombre;
    System.out.println("Producto a editar:");
    System.out.println(nombreOriginal);
    // TODO: validar que el usuario quiere editar el producto que se encontro
    System.out.print("Ingrese el nuevo nombre: ");
    String nuevoNombre = entrada.nextLine();

    // ["p1", "p2", "p3"]
    // set(1, "p38")
    // ["p1", "p38", "p3"]
    // actualizamos el nombre en el producto
    producto.nombre = nuevoNombre;

    System.out.printf("El nombre del producto cambio de %s a %s", nombreOriginal, nuevoNombre);
  }

  public static void borrarProducto(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    Producto producto = obtenerProductoPorId(productos);
    // TODO: validar que encontramos el producto
    String nombreOriginal = producto.nombre;
    System.out.println("Producto a borrar:");
    System.out.println(nombreOriginal);
    // TODO: validar que el usuario quiere borrar el producto que se encontro

    // aca borramos el producto
    productos.remove(producto);
    System.out.println("Borrado exitosamente!");
  }

  /* UTILIDADES */
  /* Busqueda por id - ahora mismo solo funciona con el indice, en el futuro se va a cambiar */
  public static Producto obtenerProductoPorId(List<Producto> productos) {
    Scanner entrada = new Scanner(System.in);
    // TODO: validacion de datos
    System.out.println("Ingrese el id del producto: ");
    int idBusqueda = entrada.nextInt();

    for (Producto producto : productos) {
      if (producto.id == idBusqueda) {
        return producto;
      }
    }

    return null; // el null representa que no encontramos el producto
  }

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

  public static ArrayList<Producto> obtenerProductosTecnologicos() {
    ArrayList<Producto> productos = new ArrayList<>();

    productos.add(new Producto(1, "Laptop Lenovo ThinkPad X1 Carbon"));
    productos.add(new Producto(2, "Mouse inalámbrico Logitech MX Master 3"));
    productos.add(new Producto(3, "Teclado mecánico Razer BlackWidow V4"));
    productos.add(new Producto(4, "Monitor LG UltraWide 34 pulgadas"));
    productos.add(new Producto(5, "Smartphone Samsung Galaxy S23 Ultra"));
    productos.add(new Producto(6, "Tablet Apple iPad Pro 12.9\""));
    productos.add(new Producto(7, "Disco duro externo Seagate 2TB"));
    productos.add(new Producto(8, "Memoria RAM Corsair Vengeance 16GB"));
    productos.add(new Producto(9, "Cargador inalámbrico Belkin Boost Up"));
    productos.add(new Producto(10, "Auriculares Bluetooth Sony WH-1000XM5"));

    return productos;
  }
}
