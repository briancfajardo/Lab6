package domain;
import java.awt.Color;
import java.util.*;

/**
 * Inquietas es un tipo de célula de color naranja que muere cuando
 * alguna de sus vecinas está muerta y crea dos células si no tiene
 * vecinas
 *
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class Inquietas extends Cell
{
    /**
     * Constructor for objects of class Inquietas
     */
    public Inquietas(CellularAutomata ac,int row, int column)
    {
        super(ac, row, column);
        super.color = Color.orange;
        //state = Agent.ALIVE;
    }

    /**
     * @override
     * Decide its next state
     */
    public void decide(){
        //Si algunas de sus vecinas está muerta, ella muere
        if (super.getMuertas() > 0){
            super.nextState = Agent.DEAD;
        }//Si no tiene vecinas crear una inquieta al norte y una normal al sur
        else if (super.getVivas() == 0 && super.getMuertas() == 0){
            //norte
            if (super.row - 1 >= 0){
                super.automata.createInquieta(column, row-1);
            }
            
            //sur
            if (super.row + 1 < 30){
                super.automata.someItems(column, row+1);
            }
        }
    }
}
