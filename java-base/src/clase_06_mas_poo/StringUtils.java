package clase_06_mas_poo;

public class StringUtils {

  public static String capitalizarTexto(String textoCrudo) {
    textoCrudo = textoCrudo.trim().toLowerCase();// "mensaje de texto"
    String[] palabras = textoCrudo.split(" "); // ["mensaje", "de", "texto"]

    StringBuilder sb = new StringBuilder(); // texto4 = texto1 + texto2 + texto3
    // sb = "Mensaje De Texto "
    for (String palabra : palabras) {
      if (!palabra.isEmpty()) { // si el string no esta vacio
        sb.append(Character.toUpperCase(palabra.charAt(0)))
            .append(palabra.substring(1))
            .append(" ");
      }
    }
    return sb.toString().trim();
  }
}
