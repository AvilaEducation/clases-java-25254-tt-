import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Producto> productosDB = obtenerProductosTecnologicos();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
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
            int opcionUsuario = entrada.nextInt();

            switch (opcionUsuario) {
                case 1 -> crearProducto(productosDB);
                case 2 -> listarProductos(productosDB);
                case 3 -> buscarProductoPorNombre(productosDB);
                case 4 -> editarProducto(productosDB);
                case 5 -> borrarProducto(productosDB);
                case 6 -> filtroPorPrecio(productosDB);
                case 0 -> {
                    System.out.println("Gracias por usar la app!");
                    break label; // corta el bucle donde se ejecuta
                }
                default -> System.out.println("Opción incorrecta, intente de nuevo");
            }
        }
    }

    public static void crearProducto(ArrayList<Producto> productos) {
        System.out.println("Creando Nuevo Producto");
        System.out.print("Ingrese el nombre del nuevo producto: ");
        String nombre = entrada.nextLine();
        double precio = entrada.nextDouble();
        String descripcion = entrada.nextLine();
        // podriamos tener bucles que validen los datos
        String categoria = entrada.nextLine();

        // TODO: cambiarlo cuando veamos static
        productos.add(new Producto(nombre, precio, descripcion, categoria));

        // TODO: agregar un mensaje de confirmación cuando se crea el producto
        pausa();
    }

    public static void listarProductos(ArrayList<Producto> productos) {
        System.out.println("==============================================================================================");
        System.out.println("                                  LISTA DE PRODUCTOS TECNOLÓGICOS                             ");
        System.out.println("==============================================================================================");

        if (productos == null || productos.isEmpty()) {
            System.out.println("⚠️  No hay productos para mostrar.");
        } else {
            System.out.printf("| %-3s | %-35s | %-10s | %-20s | %-15s |%n",
                    "ID", "Nombre", "Precio", "Categoría", "Descripción");
            System.out.println("----------------------------------------------------------------------------------------------");

            for (Producto producto : productos) {
                System.out.printf("| %3d | %-35s | $%9.2f | %-20s | %-15s |%n",
                        producto.getId(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getCategoria(),
                        acortarDescripcion(producto.getDescripcion(), 15));
            }
        }

        System.out.println("==============================================================================================");
        pausa();
    }

    private static String acortarDescripcion(String descripcion, int maxLength) {
        if (descripcion.length() <= maxLength) {
            return descripcion;
        } else {
            return descripcion.substring(0, maxLength - 3) + "...";
        }
    }


    public static void buscarProductoPorNombre(ArrayList<Producto> productos) {
        System.out.println("Ingrese un nombre de un producto: ");
        String busqueda = entrada.nextLine();
        ArrayList<Producto> productoEncontrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (estaIncluido(producto.getNombre(), busqueda)) {
                productoEncontrados.add(producto);
            }
        }

        listarProductos(productoEncontrados);
    }

    public static void editarProducto(List<Producto> productos) {
        // el listado de productos tiene las direcciones de memoria de los productos originales
        // aca obtenemos la direccion de memoria que nos permite modificar el objeto original
        // que es uno de los que esta en el listado
        Producto producto = obtenerProductoPorId(productos);
        // TODO: validar que encontramos el producto
        if (producto == null) {
            System.out.println("No se puede editar el producto.");
            pausa();
            return; // cuando hacemos el return en una funcion void, estamos cortando la ejecucion de la funcion
        }

        String nombreOriginal = producto.getNombre();
        System.out.println("Producto a editar:");
        System.out.println(nombreOriginal);
        // TODO: validar que el usuario quiere editar el producto que se encontro
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = entrada.nextLine();

        // ["p1", "p2", "p3"]
        // set(1, "p38")
        // ["p1", "p38", "p3"]
        // actualizamos el nombre en el producto
        producto.setNombre(nuevoNombre);

        System.out.printf("El nombre del producto cambio de %s a %s", nombreOriginal, nuevoNombre);
    }

    public static void borrarProducto(List<Producto> productos) {
        Producto producto = obtenerProductoPorId(productos);
        // TODO: validar que encontramos el producto
        if (producto == null) {
            System.out.println("No pudimos borrar el producto");
            pausa();
            return; //
        }
        String nombreOriginal = producto.getNombre();
        System.out.println("Producto a borrar:");
        System.out.println(nombreOriginal);
        // TODO: validar que el usuario quiere borrar el producto que se encontro

        // aca borramos el producto
        productos.remove(producto);
        System.out.println("Borrado exitosamente!");
    }

    public static void filtroPorPrecio(List<Producto> productos) {
        double precioFiltro = entrada.nextDouble();

        ArrayList<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getPrecio() <= precioFiltro) {
                productosFiltrados.add(producto);
            }
        }

        listarProductos(productosFiltrados);
    }

    /* UTILIDADES */
    /* Busqueda por id - ahora mismo solo funciona con el indice, en el futuro se va a cambiar */
    public static Producto obtenerProductoPorId(List<Producto> productos) {
        // TODO: validacion de datos
        System.out.println("Ingrese el id del producto: ");
        int idBusqueda = entrada.nextInt();

        for (Producto producto : productos) {
            if (producto.coincideId(idBusqueda)) {
                return producto;
            }
        }

        System.out.println("No pudimos encontrar el producto con el id: " + idBusqueda);
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
        System.out.println("Pulse ENTER para continuar...");
        entrada = new Scanner(System.in);
        entrada.nextLine();
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
        // TODO: limpiar la pantalla de la consola
    }

    public static ArrayList<Producto> obtenerProductosTecnologicos() {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(
                "Laptop Lenovo ThinkPad X1 Carbon",
                1899.99,
                "Ultrabook empresarial de alto rendimiento con diseño liviano y duradero.",
                "Computadoras"));

        productos.add(new Producto(
                "Mouse inalámbrico Logitech MX Master 3",
                99.99,
                "Mouse ergonómico con múltiples botones programables y conectividad Bluetooth.",
                "Accesorios"));

        productos.add(new Producto(
                "Teclado mecánico Razer BlackWidow V4",
                179.99,
                "Teclado gaming mecánico con retroiluminación RGB y teclas programables.",
                "Periféricos"));

        productos.add(new Producto(
                "Monitor LG UltraWide 34 pulgadas",
                499.99,
                "Monitor panorámico con resolución QHD ideal para multitarea y productividad.",
                "Monitores"));

        productos.add(new Producto(
                "Smartphone Samsung Galaxy S23 Ultra",
                1199.99,
                "Teléfono inteligente de gama alta con cámara de 200 MP y pantalla AMOLED.",
                "Smartphones"));

        productos.add(new Producto(
                "Tablet Apple iPad Pro 12.9\"",
                1399.99,
                "Tableta potente con chip M2 y pantalla Liquid Retina XDR.",
                "Tablets"));

        productos.add(new Producto(
                "Disco duro externo Seagate 2TB",
                79.99,
                "Almacenamiento portátil confiable con conectividad USB 3.0.",
                "Almacenamiento"));

        productos.add(new Producto(
                "Memoria RAM Corsair Vengeance 16GB",
                69.99,
                "Módulo de memoria DDR4 ideal para gamers y entusiastas del rendimiento.",
                "Componentes"));

        productos.add(new Producto(
                "Cargador inalámbrico Belkin Boost Up",
                39.99,
                "Base de carga inalámbrica rápida compatible con dispositivos Qi.",
                "Accesorios"));

        productos.add(new Producto(
                "Auriculares Bluetooth Sony WH-1000XM5",
                349.99,
                "Auriculares con cancelación activa de ruido y audio de alta resolución.",
                "Audio"));

        return productos;
    }

}
