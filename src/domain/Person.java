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
}

