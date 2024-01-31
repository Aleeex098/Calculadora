package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;
/**
 * @author Derek 🙈
 * La clase Calculadora proporciona un programa simple que permite al usuario realizar operaciones matemáticas básicas.
 */
public class Calculadora {
	  private static final Logger logger = Logger.getLogger(Calculadora.class.getName());

    public static void main(String[] args) throws IOException
    {   
    	logger.setLevel(Level.ALL);
    	logger.setUseParentHandlers(false);
    	
    	Handler consoleHandler = new ConsoleHandler();
    	Handler fileHandler = null;
    	consoleHandler.setLevel(Level.WARNING);
    	
    	logger.addHandler(consoleHandler);
    	try {
    		fileHandler = new FileHandler("C://Users/1AW3-22/git/Calculadora/logs/operaciones.log", true);
    		logger.addHandler(fileHandler);
    		fileHandler.setLevel(Level.ALL);
    		} catch (IOException exception) {
    		logger.log(Level.WARNING, "Error al cargar la configuración",exception);
    		
    	}
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
