package domain;
import java.util.*;
import java.awt.Color;


/**
 * Bulb es una bombilla que inicia cuadrada de color amarillo que cuando
 * aumenta su edad, cambia de forma a círculo, y después vuelve a cambiar
 * su forma a cuadrado. Esto sucede hasta que llega a los 100 clics (100 años)
 * donde se funde y queda gris y redonda
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class Bulb extends Agent implements Item
{
    private char nextState;
    private int nextShape;
    private Color color;
    private CellularAutomata automata;
    private int row,column;
    private String shape = "ROUND";
    /**
     * Constructor for objects of class Bulb
     */
    public Bulb(CellularAutomata ac,int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState = Agent.ALIVE;
        automata.setItem(row,column,(Item)this);
        color=Color.yellow;

    }
    
    /**
     * @override
     * Decide its next state
     */
    public void decide(){
        if (getAge() > 8){
            color = Color.gray;
        }else{
            if (shape.equals("SQUARE")){
                shape = "ROUND";
            }else{
                shape = "SQUARE";
            }
        }
    }
    
    /**
     * Change its actual state
     */
    public final void change(){
        turn();
        state = nextState;
    }
    
    /**
     * Change its actual shape
     */
    public int shape(){
        if (shape.equals("ROUND")){
            return SQUARE;
        }else{
            return ROUND;
        }
    }
    
    /**Returns the color
    @return Color
     */
    public final Color getColor(){
        return color;
    }
}
