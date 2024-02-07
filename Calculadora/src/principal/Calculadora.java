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

        // Configuración del manejador de la consola
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        logger.addHandler(consoleHandler);

        // Configuración del manejador de archivo para operaciones.log
        FileHandler fileHandlerLog = null;
        try {
            fileHandlerLog = new FileHandler("logs/operaciones.log", true); // El segundo argumento 'true' indica que se agregará al final del archivo
            fileHandlerLog.setLevel(Level.FINE); // Cambio a Level.FINE para que se registren todas las operaciones exitosas
            fileHandlerLog.setFormatter(new java.util.logging.SimpleFormatter());
            logger.addHandler(fileHandlerLog);
        } catch (IOException exception) {
            logger.log(Level.WARNING, "Error al cargar la configuración del archivo de operaciones", exception);
        }

        int resultado = 0;
        String operacion = "";
        int[] operandos = new int[2];

        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();

        FileWriter htmlWriter = new FileWriter("logs/resultadosCalculadora.html", true);
        htmlWriter.write(
                "<!DOCTYPE html><html><head><title>Resultados de la Calculadora</title><link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head><body>");

        do {
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();

            try {
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

                htmlWriter.write("<tr>\r\n" + "				<td>" + operacion + "</td>\r\n" + "				<td>"
                        + operandos[0] + "</td>\r\n" + "				<td>" + operandos[1] + "</td>\r\n" + "				<td>"
                        + resultado + "</td>\r\n" + "			</tr>\r\n");
            } catch (ArithmeticException e) {
                logger.warning("Operacion no Valida");
            }

        } while (menu.repetir());

        htmlWriter.write("</body></html>");
        htmlWriter.close();

        if (fileHandlerLog != null) {
            fileHandlerLog.close();
        }
    }
}



