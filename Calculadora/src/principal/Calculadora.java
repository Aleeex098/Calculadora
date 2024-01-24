package principal;

import menu.Menu;
import operaciones.Operaciones;

/**
 * @author Derek 🙈
 * La clase Calculadora proporciona un programa simple que permite al usuario realizar operaciones matemáticas básicas.
 */
public class Calculadora {

    /**
     * El método principal que ejecuta la calculadora.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {   
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int[2];
        
        // Se crea una instancia de la clase Menu y Operaciones para realizar las operaciones.
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do {
            // Se solicitan los números y la operación al usuario.
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            // Se realiza la operación seleccionada y se muestra el resultado.
            if (operacion.equalsIgnoreCase("+")) {
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("-")) {
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("*")) {
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("/")) {
                resultado = operaciones.dividir(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("%")) {
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Operación no válida");
            }
        } while (menu.repetir());
    }
}
