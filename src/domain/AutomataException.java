package domain;

public class AutomataException extends Exception{
    public static final String AUTOMATA_EXCEPTION = "Nombre del archivo es vacío";
    public AutomataException(String msg){
        super(msg);
    }
}
