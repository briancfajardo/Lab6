package domain;
import java.io.Serializable;
import java.util.*;
import java.awt.Color;


/**
 * Una persona muere si está totalmente rodeada y vive si no lo está porque
 * puede escapar
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class Person extends Agent implements Item, Serializable
{
    private char nextState;
    private int nextShape;
    private Color color;
    private CellularAutomata automata;
    private int row,column;
    private String shape = "SQUARE";
    
    /**
     * Constructor for objects of class Person
     */
    public Person(CellularAutomata ac,int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState = Agent.ALIVE;
        automata.setItem(row,column,(Item)this);
        color=Color.pink;
    }

    /**
     * Segundo constructor de la clase Inquietas
     * Contiene todos los parámetros necesarios para duplicar el objeto
     * @param ac
     * @param row
     * @param column
     * @param state
     * @param nextState
     * @param age
     * @param color
     *
     */

    public Person(CellularAutomata ac,int row, int column, char state, char nextState, int age, Color color){
        automata=ac;
        this.row=row;
        this.column=column;
        this.state = state;
        this.nextState=nextState;
        this.age = age;
        automata.setItem(row,column,(Item)this);
        this.color= color;
    }
    
    /**
     * @override
     * Decide its next state
     */
    
    public void decide(){
        int cont = 0;
        ArrayList <Integer> nulas = automata.nulas(column, row);
        if (nulas.get(2) == 0){
            nextState = Agent.DEAD;
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
     * Define su forma como cuadrado
     */
    public int shape(){
        return SQUARE;
    }
    
    /**Returns the color
    @return Color
     */
    public final Color getColor(){
        return color;
    }

    /**
     * Método que decide cómo se verá la escritura de un objeto de la clase
     * Person cuando se imprima como String
     * @return String texto
     */
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

