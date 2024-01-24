package operaciones;

/**
 * @author Derek
 * La clase Operaciones proporciona métodos para realizar operaciones matemáticas básicas.
 */
public class Operaciones {

    /**
     * Suma dos números enteros.
     *
     * @param valor1 El primer número a sumar.
     * @param valor2 El segundo número a sumar.
     * @return La suma de los dos números.
     */
    public int sumar(int valor1, int valor2) {
        int numero;
        numero = valor1 + valor2;
        return numero;
    }

    /**
     * Resta el segundo número del primero.
     *
     * @param valor1 El número del que se resta.
     * @param valor2 El número que se resta.
     * @return La resta de los dos números.
     */
    public int restar(int valor1, int valor2) {
        int numero;
        numero = valor1 - valor2;
        return numero;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param valor1 El primer número a multiplicar.
     * @param valor2 El segundo número a multiplicar.
     * @return El producto de los dos números.
     */
    public int multiplicar(int valor1, int valor2) {
        int numero;
        numero = valor1 * valor2;
        return numero;
    }

    /**
     * Divide el primer número por el segundo.
     *
     * @param valor1 El numerador.
     * @param valor2 El denominador (debe ser diferente de cero).
     * @return El cociente de la división.
     */
    public int dividir(int valor1, int valor2) {
        int numero;
        numero = valor1 / valor2;
        return numero;
    }

    /**
     * Calcula el resto de la división del primer número por el segundo.
     *
     * @param valor1 El número del que se calcula el resto.
     * @param valor2 El divisor.
     * @return El resto de la división.
     */
    public int resto(int valor1, int valor2) {
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}
