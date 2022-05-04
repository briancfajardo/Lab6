package domain;
import java.awt.Color;
import java.io.Serializable;
import java.util.*;

/**
 * Colorin es un tipo de célula que cambia de color al tiempo
 * que aumenta su edad en un orden especificado de colores
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class Colorin extends Cell implements Serializable
{
    private String[] colors = {"red", "yellow", "blue", "green","cyan", "orange", "pink", "magenta"};
    private int cont = 0;
    /**
     * Constructor for objects of class Colorin
     */
    public Colorin(CellularAutomata ac,int row, int column)
    {
        super(ac, row, column);
        super.color = Color.green;
    }

    public Colorin(CellularAutomata ac,int row, int column, char state, char nextState, int age, Color color){
        super(ac,row, column, state, nextState,age,color);

    }
    
    /**
     * @override
     * Decide its next state
     */
    public void decide(){
        super.color = changeColor();
    }
    
    /**Returns the next color
    @return Color
     */
    public Color changeColor(){
        if (cont < 7){
            cont +=1;
        }else{
            cont = 0;
        }
        String newColor = colors[cont];
        
        if (newColor == "red"){
            return Color.red;
        }else if(newColor == "yellow"){
            return Color.yellow;
        }else if(newColor == "blue"){
            return Color.blue;
        }else if(newColor == "green"){
            return Color.green;
        }else if(newColor == "cyan"){
            return Color.cyan;
        }else if(newColor == "orange"){
            return Color.orange;
        }else if(newColor == "pink"){
            return Color.pink;
        }else if(newColor == "magenta"){
            return Color.magenta;
        }else{
            return Color.orange;
        }
    }
}
