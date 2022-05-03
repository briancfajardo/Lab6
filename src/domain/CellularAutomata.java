package domain;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * Es una grilla que está formada por un arreglo de objetos de tipo Item
 * Su longitud es 30 actualmente
 * Su estado es lo que se ve al ejecutar la aplicación
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class CellularAutomata implements Serializable{
    static private int LENGTH=30;
    private Item[][] automata;
    
    /**
     * Constructor for objects of class Conway
     */
    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
        someItems("indiana", 1,1);
        change(1,1);
        createInquieta("agamenon",3,2);
        createInquieta("venus",10,10);
    }


    /**
     * Método que abre un arhivo en lenguaje no natural, según la descripción del objeto
     * @param -File archivo
     */
    public void abra00(File archivo) throws AutomataException{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
    }

    public CellularAutomata abra(String archivo) throws Exception{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
        FileInputStream inFile = new FileInputStream(archivo);
        ObjectInputStream inObject = new ObjectInputStream(inFile);
        CellularAutomata nuevo = (CellularAutomata)inObject.readObject();
        System.out.println(nuevo);
        inObject.close();
        return nuevo;
    }


    /**
     * Método que guarda un arhivo en lenguaje no natural, según la descripción del objeto
     * @param -File archivo
     */
    public void guarde00(File archivo) throws AutomataException{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
    }


    /**
     * Método que guarda un arhivo en lenguaje no natural, según la descripción del objeto
     * @param -File archivo
     */
    public void guarde(String archivo) throws Exception{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
        FileOutputStream outFile = new FileOutputStream(archivo);
        ObjectOutputStream outObject = new ObjectOutputStream(outFile);
        outObject.writeObject(this);
        outObject.close();
    }


    /**
     * Método que importa un arhivo en lenguaje natural, según la
     * descripción del objeto
     * @param -File archivo
     */
    public void importe(File archivo) throws AutomataException{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
    }


    /**
     * Método que importa un arhivo en lenguaje natural, según la descripción del objeto
     * @param -File archivo
     */
    public void exporte(File archivo) throws AutomataException{
        if (archivo == null) throw new AutomataException(AutomataException.AUTOMATA_EXCEPTION);
    }

    /**
     * Método que genera un nuevo objeto CellularAutomata
     * @param -void
     * @return -CellularAutomata
     */
    public CellularAutomata nuevo(){
        return new CellularAutomata();
    }

    /**
     * Define si el item en esa ubicación está vivo
     */
    public Boolean isAlive(int r, int c){
        if (automata[r][c] != null){
            return automata[r][c].isAlive();
        }
        return false;
    }
    
    /**
     * Retorna el color del item en la ubicación ingresada
     */
    public Color getColor(int r, int c){
        return automata[r][c].getColor();
    }
    
    /**
     * Define si el item en esa ubicación está muerto
     */
    public boolean isDead(int r, int c){
        if (automata[r][c] != null){
            return !automata[r][c].isAlive();
        }
        return false;
    }
    
    /**
     * Define si el item en esa ubicación no existe
     */
    public boolean isNull(int r, int c){
        return automata[r][c] == null;
    }
    
    /**
     * Crea en una ubicación específica una célula Inquieta
     */
    public void createInquieta(int r, int c){
        automata[c][r] = new Inquietas (this, c, r);
    }
    
    /**
     * Crea en una ubicación específica una célula Inquieta
     * con nombre
     */
    public void createInquieta(String name, int r, int c){
        automata[c][r] = new Inquietas (this, c, r);
    }
    
    /**
     * Retorna la longitud de la grilla
     */
    public int  getLength(){
        return LENGTH;
    }
    
    /**
     * Retorna un Item en una ubicacion especifica
     */
    public Item getItem(int r,int c){
        return automata[r][c];
    }

    /**
     * Modifica un Item en una ubicacion especifica
     */
    public void setItem(int r, int c, Item e){
        automata[r][c]=e;
    }
    
    /**
     * Cambia el estado actual
     */
    public void change(int posX, int posY){
        automata[posY][posX].decide();
        automata[posY][posX].change();
    }
    
    /**
     * Decide el siguiente estado
     */
    public void decide(int posX, int posY){
        automata[posY][posX].decide();
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Cell con nombre
     */
    public void someItems(String name, int posX, int posY){
        automata[posY][posX] = new Cell(this, posY, posX, name);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Cell
     */
    public void someItems(int posX, int posY){
        automata[posY][posX] = new Cell(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Bulb
     */
    public void someItemBulb(int posX, int posY){
        automata[posY][posX] = new Bulb(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Bulb con nombre
     */
    public void someItemBulb(String name, int posX, int posY){
        automata[posY][posX] = new Bulb(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Colorin
     */
    public void someItemColorin(String name, int posX, int posY){
        automata[posY][posX] = new Colorin(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Person con nombre
     */
    public void someItemPerson(String name, int posX, int posY){
        automata[posY][posX] = new Person(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Conway con nombre
     */
    public void someItemConway(String name, int posX, int posY){
        automata[posY][posX] = new Conway(this, posY, posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Conway
     */
    public void someItemConway(int posX, int posY){
        automata[posY][posX] = new Conway(this, posY, posX);
    }
    
    /**
     * Crea un patrón específico (células Conway) dentro de la grilla
     * Se ingresa como parámetro la ubicación de la esquina izquierda superior
     */
    public void patrones (int row, int column, String patron){
        if(patron.equals("Bloque") && (row + 1) < LENGTH && (column + 1) < LENGTH && automata[row][column] == null 
        && automata[row+1][column] == null && automata[row][column+1] == null && automata[row+1][column+1] == null){
            someItemConway(column, row);
            someItemConway(column+1, row);
            someItemConway(column, row+1);
            someItemConway(column+1, row+1);
        }else if(patron.equals("Barco") && (row + 2) < LENGTH && (column + 2) < LENGTH && automata[row][column] == null 
        && automata[row+1][column] == null && automata[row][column+1] == null && automata[row+1][column+1] == null 
        && automata[row+2][column] == null && automata[row+2][column+1] == null && automata[row][column+2] == null 
        && automata[row+1][column+2] == null && automata[row+2][column+2] == null){
            someItemConway(column, row);
            someItemConway(column+1, row);
            someItemConway(column, row+1);
            someItemConway(column+2, row+1);
            someItemConway(column+1, row+2);
        }else if(patron.equals("Parpadeador") && (column + 2) < LENGTH && automata[row][column] == null 
        && automata[row][column+1] == null && automata[row][column+2] == null){
            someItemConway(column, row);
            someItemConway(column+1, row);
            someItemConway(column+2, row);
        }
    }
    
    /**
     * Crea una célula normal en (5,5)
     */
    public void someItems(){
        new Cell(this, 5, 5);
    }
    
    /**
     * Implementa los cambios necesarios cada vez que el usuario hace un llamado al botón de tic tac
     * Según el Item dentro del CellularAutomata, su comportamiento varía
     */
    public void ticTac(){
        ArrayList<Integer> veci = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> noNull = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> Null = new ArrayList<ArrayList<Integer>>();
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                if (automata[r][c] != null){
                    //automata[c][r].getMuertas();
                    ArrayList<Integer> aux = new ArrayList<Integer>();
                    aux.add(r);
                    aux.add(c);
                    noNull.add(aux);
                }else{
                    veci = vivas(c, r);
                    if (veci.get(2) == 3){
                        ArrayList<Integer> aux = new ArrayList<Integer>();
                        aux.add(r);
                        aux.add(c);
                        Null.add(aux);
                    }
                }
            }
        }
        for (ArrayList<Integer> n : noNull){
            automata[n.get(0)][n.get(1)].decide();
        }
        for (ArrayList<Integer> n : noNull){
            automata[n.get(0)][n.get(1)].change();
        }
        for (ArrayList<Integer> n : Null){
            automata[n.get(0)][n.get(1)] = new Conway(this, n.get(0), n.get(1));
        }
    }
    
    /**
     * Retorna la posición del centro (célula que se está evaluando) junto con el número de sus
     * vecinas vivas
     */
    public ArrayList<Integer> vivas(int c, int r){
        int cont = 0;
        ArrayList<Integer> aux = new ArrayList<Integer>();
        if (r-1 >= 0 && c-1 >= 0 && automata[r-1][c-1] != null && automata[r-1][c-1].isAlive()){
            cont += 1;
        }
        
        if (r-1 >= 0 && automata[r-1][c] != null && automata[r-1][c].isAlive()){
            cont += 1;
        }
        
        if (r-1 >= 0 && c+1 < LENGTH && automata[r-1][c+1] != null && automata[r-1][c+1].isAlive()){
            cont += 1;
        }
            
        if (c-1 >= 0 && automata[r][c-1] != null && automata[r][c-1].isAlive()){
            cont += 1;
        }
        
        if (c+1 < LENGTH && automata[r][c+1] != null && automata[r][c+1].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c-1 >= 0 && automata[r+1][c-1] != null && automata[r+1][c-1].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && automata[r+1][c] != null && automata[r+1][c].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c+1 < LENGTH && automata[r+1][c+1] != null && automata[r+1][c+1].isAlive()){
            cont += 1;
        }
        aux.add(r);
        aux.add(c);
        aux.add(cont);
        return aux;

    }
    
    /**
     * Retorna la posición del centro (célula que se está evaluando) junto con el número de sus
     * vecinas muertas
     */
    public ArrayList<Integer> muertas(int c, int r){
        int cont = 0;
        ArrayList<Integer> aux = new ArrayList<Integer>();
        if (r-1 >= 0 && c-1 >= 0 && automata[r-1][c-1] != null && !automata[r-1][c-1].isAlive()){
            cont += 1;
        }
        
        if (r-1 >= 0 && automata[r-1][c] != null && !automata[r-1][c].isAlive()){
                cont += 1;
        }
        
        if (r-1 >= 0 && c+1 < LENGTH && automata[r-1][c+1] != null && !automata[r-1][c+1].isAlive()){
            cont += 1;
        }
            
        if (c-1 >= 0 && automata[r][c-1] != null && !automata[r][c-1].isAlive()){
            cont += 1;
        }
        
        if (c+1 < LENGTH && automata[r][c+1] != null && !automata[r][c+1].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c-1 >= 0 && automata[r+1][c-1] != null && !automata[r+1][c-1].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && automata[r+1][c] != null && !automata[r+1][c].isAlive()){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c+1 < LENGTH && automata[r+1][c+1] != null && !automata[r+1][c+1].isAlive()){
            cont += 1;
        }
        aux.add(r);
        aux.add(c);
        aux.add(cont);
        return aux;

    }
    
    /**
     * Retorna la posición del centro (célula que se está evaluando) junto con el número de sus
     * vecinas nulas
     */
    public ArrayList<Integer> nulas(int c, int r){
        int cont = 0;
        ArrayList<Integer> aux = new ArrayList<Integer>();
        if (r-1 >= 0 && c-1 >= 0 && automata[r-1][c-1] == null){
            cont += 1;
        }
        
        if (r-1 >= 0 && automata[r-1][c] == null){
                cont += 1;
        }
        
        if (r-1 >= 0 && c+1 < LENGTH && automata[r-1][c+1] == null){
            cont += 1;
        }
            
        if (c-1 >= 0 && automata[r][c-1] == null){
            cont += 1;
        }
        
        if (c+1 < LENGTH && automata[r][c+1] == null){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c-1 >= 0 && automata[r+1][c-1] == null){
            cont += 1;
        }
        
        if (r+1 < LENGTH && automata[r+1][c] == null){
            cont += 1;
        }
        
        if (r+1 < LENGTH && c+1 < LENGTH && automata[r+1][c+1] == null){
            cont += 1;
        }
        aux.add(r);
        aux.add(c);
        aux.add(cont);
        return aux;

    }
    
    
}
