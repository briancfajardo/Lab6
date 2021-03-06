package domain;
import java.awt.Color;
import java.io.Serializable;
import java.util.*;

/**
 * Las células conway nacen si tienen 3 vecinas vivas, mueren si tienen diferente de dos o tres vecinas vivas
 * y se mantienen vivas si lo anterior se cumple
 *
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class Conway extends Cell implements Serializable
{
    /**
     * Constructor for objects of class Conway
     */
    public Conway(CellularAutomata ac,int row, int column)
    {
        super(ac, row, column);
        super.nextState=Agent.ALIVE;
        super.color = Color.blue;
        super.change();
    }

    /**
     * Segundo constructor de la clase Conway
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
    public Conway(CellularAutomata ac,int row, int column, char state, char nextState, int age, Color color){
        super(ac,row, column, state, nextState,age,color);

    }
    /**
     * @override
     * Decide its next state
     */
    public void decide(){
        //Si 3 de sus vecinas están vivas ella vive
        if (super.getVivas() == 3){
            super.nextState = Agent.ALIVE;
        }else if(state == Agent.ALIVE && super.getVivas() == 2){
            super.nextState = Agent.ALIVE;
        }
        //Si tiene menos de dos o más de tres células vecinas vivas muere
        else if (super.getVivas() < 2 || super.getVivas() > 3){
            super.nextState = Agent.DEAD;
        }
    }
}

