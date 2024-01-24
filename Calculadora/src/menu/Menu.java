package menu;

import java.util.Scanner;

/**
 * @author Derek
 * La clase Menu proporciona métodos para interactuar con el usuario y obtener entrada para operaciones matemáticas.
 */
public class Menu {
    
    private static Scanner teclado = new Scanner(System.in);
    
    /**
     * Pide al usuario dos números enteros.
     *
     * @return Un array de dos enteros, donde el primer elemento es el primer operando y el segundo elemento es el segundo operando.
     */
    public int[] pedirNumeros() {
        int[] ret = new int[2];
        System.out.print("Operando 1: ");
        ret[0] = teclado.nextInt();
        System.out.print("Operando 2: ");
        ret[1] = teclado.nextInt();
        return ret;
    }
    
    /**
     * Muestra un menú de opciones y solicita al usuario que elija una operación.
     *
     * @return La operación seleccionada como una cadena (puede ser "+", "-", "*", "/", "%").
     */
    public String menuOpciones() {
        String ret = "";
        do {
            System.out.print("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||
                   (ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||
                   (ret.equalsIgnoreCase("%"))
                  ));
        return ret;
    }
    
    /**
     * Pregunta al usuario si desea continuar trabajando con la calculadora.
     *
     * @return true si la respuesta es "s" (continuar), false si la respuesta es "n" (detener).
     */
    public boolean repetir() {
        boolean ret = false;
        String respuesta;
        do {
            System.out.print("¿Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))
                    ));
                    
        if (respuesta.equalsIgnoreCase("s")) {
            ret = true;
        }
        return ret;
    }
}
