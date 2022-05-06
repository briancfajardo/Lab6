package domain;

/** Clase de exceciones posibles de la clase CellularAutomata
 * @author Camilo Fajardo, Andrea Duran
 * @version 04/05/2022
 *
 */
public class AutomataException extends Exception{
    public static final String AUTOMATA_EXCEPTION = "Nombre del archivo es vacío";
    public static final String NUMERO_INVALIDO = "Es un número inválido";
    public static final String COLOR_INVALIDO = "Es un color inválido";
    public final static String COMPILER_ERROR = "Error en la linea ";
    public static final String OBJETO_INVALIDO = "Es un objeto inválido";
    public AutomataException(String msg){
        super(msg);
    }
}
