package domain;
import java.io.Serializable;
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
public class Bulb extends Agent implements Item, Serializable
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
     * Segundo constructor de la clase Bulb
     * Contiene todos los parámetros necesarios para duplicar el objeto
     * @param ac
     * @param row
     * @param column
     * @param state
     * @param nextState
     * @param age
     * @param color
     * @param shape
     *
     */
    public Bulb(CellularAutomata ac,int row, int column, char state, char nextState, int age, Color color, String shape){
        automata=ac;
        this.row=row;
        this.column=column;
        this.state = state;
        this.nextState=nextState;
        this.age = age;
        automata.setItem(row,column,(Item)this);
        this.shape = shape;
        this.color=color;
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

    /**
     * Método que decide cómo se verá la escritura de un objeto de la clase
     * Bulb cuando se imprima como String
     * @return String texto
     */
    @Override
    public String toString(){
        String texto = "";
        texto += this.getClass() + " ";
        texto += row + " ";
        texto += column + " ";
        texto += state + " ";
        decide();
        texto += nextState + " ";
        texto += this.getAge() + " ";
        texto += color.getRGB() + " ";
        texto += shape;
        return texto;
    }
}
