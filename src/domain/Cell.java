package domain;
import java.io.Serializable;
import java.util.*;
import java.awt.Color;

/**Information about a cell<br>
<b>(automata,row,column,age,state,nextState, color)</b><br>
<br>
 */
public class Cell extends Agent implements Item, Serializable {
    protected char nextState;
    protected Color color;
    protected CellularAutomata automata;
    protected int row,column;
    private String name;


    /**Create a new cell (<b>row,column</b>) in the automata <b>ac</b>.
     * Every new cell is going to be alive in the following state.
     * @param ac 
     * @param row 
     * @param column 
     */
    public Cell(CellularAutomata ac,int row, int column){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState=Agent.ALIVE;
        automata.setItem(row,column,(Item)this);    
        color=Color.red;
    }
    
    /**Create a new cell (<b>row,column</b>) in the automata <b>ac</b>.
     * Every new cell is going to be alive in the following state.
     * @param ac 
     * @param row 
     * @param column 
     * @param name
     */
     public Cell(CellularAutomata ac,int row, int column, String name){
        automata=ac;
        this.row=row;
        this.column=column;
        nextState=Agent.ALIVE;
        automata.setItem(row,column,(Item)this);
        color=Color.red;
        this.name = name;
    }

    /**
     * Segundo constructor de la clase Cell
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
    public Cell(CellularAutomata ac,int row, int column, char state, char nextState, int age, Color color){
        automata=ac;
        this.row=row;
        this.column=column;
        this.state = state;
        this.nextState=nextState;
        this.age = age;
        automata.setItem(row,column,(Item)this);
        this.color= color;
    }
    

    /**Returns the row
    @return int
     */
    public final int getRow(){
        return row;
    }

    /**Returns the column
    @return int
     */
    public final int getColumn(){
        return column;
    }

    
    /**Returns the color
    @return Color
     */
    public final Color getColor(){
        return color;
    }


    /**Decide its next state
     */
    public void decide(){
        if (getAge()>=3){
            nextState=Agent.DEAD;
        }   
    }

    /**Change its actual state
     */
    public final void change(){
        turn();
        state=nextState;
    }
    
    /**Retorna las vecinas muertas
    @return int
     */
    public int getMuertas(){
        return automata.muertas(column, row).get(2);
    }
    
    /**Retorna las vecinas vivas
    @return int
     */
    public int getVivas(){
        return automata.vivas(column, row).get(2);
    }
    
    /**Retorna las vecinas nulas
    @return int
     */
    public int getNulas(){
        return automata.nulas(column, row).get(2);
    }

    /**
     * Método que decide cómo se verá la escritura de un objeto de la clase
     * Cell cuando se imprima como String
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
        texto += color.getRGB();
        return texto;
    }
}
    
