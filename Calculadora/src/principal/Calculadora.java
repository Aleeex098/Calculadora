package principal;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;

public class Calculadora {
    private static final Logger logger = Logger.getLogger(Calculadora.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);

        // Manejador para la consola
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        logger.addHandler(consoleHandler);

        // Manejador para el archivo HTML
        FileHandler fileHandlerHtml = null;
        try {
            fileHandlerHtml = new FileHandler("ResultadoCalculadora.html");
            fileHandlerHtml.setLevel(Level.ALL);
            logger.addHandler(fileHandlerHtml);
        } catch (IOException exception) {
            logger.log(Level.WARNING, "Error al cargar la configuración del archivo HTML", exception);
        }

        // Manejador para el archivo de operaciones.log
        FileHandler fileHandlerLog = null;
        try {
            fileHandlerLog = new FileHandler("C:/Users/1AW3-22/eclipse-workspace/Calculadora/logs/operaciones.log");
            fileHandlerLog.setLevel(Level.WARNING); // Se registran solo advertencias
            logger.addHandler(fileHandlerLog);
        } catch (IOException exception) {
            logger.log(Level.WARNING, "Error al cargar la configuración del archivo de operaciones", exception);
        }

        int resultado = 0;
        String operacion = "";
        int[] operandos = new int[2];

        // Se crea una instancia de la clase Menu y Operaciones para realizar las
        // operaciones.
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();

        // Abre el archivo HTML para el registro de operaciones
        FileWriter htmlWriter = new FileWriter("C:/Users/1AW3-22/eclipse-workspace/Calculadora/logs/resultadosCalculadora.html",
                true);
        htmlWriter.write(
                "<!DOCTYPE html><html><head><title>Resultados de la Calculadora</title><link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head><body>");

        do {
            // Se solicitan los números y la operación al usuario.
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();

            // Se realiza la operación seleccionada y se muestra el resultado.
            if (operacion.equalsIgnoreCase("+")) {
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
                logger.fine("Operación de suma: " + operandos[0] + " + " + operandos[1] + " = " + resultado);
            } else if (operacion.equalsIgnoreCase("-")) {
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
                logger.fine("Operación de resta: " + operandos[0] + " - " + operandos[1] + " = " + resultado);
            } else if (operacion.equalsIgnoreCase("*")) {
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
                logger.fine("Operación de multiplicación: " + operandos[0] + " * " + operandos[1] + " = " + resultado);
            } else if (operacion.equalsIgnoreCase("/")) {
                resultado = operaciones.dividir(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
                logger.fine("Operación de división: " + operandos[0] + " / " + operandos[1] + " = " + resultado);
            } else if (operacion.equalsIgnoreCase("%")) {
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println("Resultado: " + resultado);
                logger.fine("Operación de módulo: " + operandos[0] + " % " + operandos[1] + " = " + resultado);
            } else {
                System.out.println("Operación no válida");
            }

            // Registra la operación en el archivo HTML
            htmlWriter.write("<tr>\r\n"
                    + "				<td>"+operacion+"</td>\r\n"
                    + "				<td>"+operandos[0]+"</td>\r\n"
                    + "				<td>"+operandos[1]+"</td>\r\n"
                    + "				<td>"+resultado+"</td>\r\n"
                    + "			</tr>\r\n");

            // Si el resultado es NaN, registrar advertencia en operaciones.log
            if (Double.isNaN(resultado)) {
                logger.warning("Intento de dividir por cero");
            }

        } while (menu.repetir());

        // Cierra el archivo HTML
        htmlWriter.write("</body></html>");
        htmlWriter.close();

        // Cierra el manejador del archivo HTML
        if (fileHandlerHtml != null) {
            fileHandlerHtml.close();
        }

        // Cierra el manejador del archivo de operaciones.log
        if (fileHandlerLog != null) {
            fileHandlerLog.close();
        }
    }
}
