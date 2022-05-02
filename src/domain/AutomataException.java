package domain;

public class AutomataException extends Exception{
    public static final String AUTOMATA_EXCEPTION = "Opcion en contruccion";
    public AutomataException(String msg){
        super(msg);
    }
}
