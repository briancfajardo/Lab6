package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Clase que se encarga de la interacción con el usuario para correr la aplicación
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */
public class AutomataGUI extends JFrame implements ActionListener{
    public static final int SIDE=21;
    public static final int SIZE=31;

    private JButton buttonTicTac;
    private JPanel panelControl;
    private PhotoAutomata photo;
    protected CellularAutomata automata;

    private JMenuBar menu;
    private JMenu archivoM;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem importar;
    private JMenuItem exportar;
    private JMenuItem salir;
    private JFileChooser archivos;
    private File partida;
    
    /**
     * Constructor for objects of class Conway
     */
    protected AutomataGUI() {
        automata=new CellularAutomata();
        //automata.someItems("indiana", 1,1);
        //automata.change(1,1);
        //automata.someItems("007", 2,2);
        //automata.change(2,2);
        //automata.createInquieta("agamenon",3,2);
        //automata.createInquieta("venus",10,10);
        
        //automata.createInquieta(8,8);
        
        //
        //automata.someItemBulb("noreste",29,0);
        
        //automata.someItemColorin("Andrea",15,20);
        //automata.someItemColorin("Camilo",20,15);
        
        //automata.someItemPerson("Escapa",18,18);
        
        //automata.someItemPerson("esquina",13,19);
        //automata.someItemPerson("esquina",14,19);
        //automata.someItemPerson("esquina",14,21);
        //automata.someItemPerson("esquina",13,20);
        //automata.someItemPerson("esquina",13,21);
        //automata.someItemPerson("esquina",15,19);
        //automata.someItemPerson("esquina",15,20);
        //automata.someItemPerson("esquina",15,21);
        
        //automata.someItemPerson("noEscapa",14,20);
        
        //automata.someItemConway("Conw",2,20);
        
        //automata.someItemConway("Conw",2,21);
        //automata.someItemConway("Conw",2,22);
        
        //automata.someItemConway("john",5,5);
        //.someItemConway("horton",6,5);
        
        //automata.someItemConway("Conw",21,21);
        //automata.someItemConway("Conw",19,21);
        
        //automata.patrones(28, 0, "Bloque");
        //automata.patrones(28, 15, "Parpadeador");
        //automata.patrones(1, 20, "Barco");
        //automata.patrones(1, 10, "Parpadeador");
        prepareElements();
        prepareActions();
    }

    private void prepareElementsMenu(){
        menu = new JMenuBar();
        setJMenuBar(menu);
        archivoM = new JMenu("Archivo");

        archivoM.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu.add(archivoM);


        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        salvar = new JMenuItem("Guardar como");
        importar = new JMenuItem("Importar");
        exportar = new JMenuItem("Exportar como");
        salir = new JMenuItem("Salir");

        nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        abrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        importar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exportar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        salvar.addActionListener(this);
        salir.addActionListener(this);
        importar.addActionListener(this);
        exportar.addActionListener(this);

        archivoM.add(nuevo);
        archivoM.add(abrir);
        archivoM.add(salvar);
        archivoM.add(importar);
        archivoM.add(exportar);
        archivoM.add(salir);

    }

    /**
     * Evento que se realiza cuando se da clic en el botón de abrir
     * Genera un JFileChooser
     */
    private void opcionAbir(){
        //System.out.println(automata.getItem(5,5).isAlive());
        try {
            archivos = new JFileChooser();
            archivos.showOpenDialog(this);
            //File archivosF =archivos.getSelectedFile();
            String nombre = archivos.getSelectedFile()+"";
            automata = automata.abra(nombre);
            photo.repaint();
            //System.out.println(b);
            //if (!nombre.equals(null+"")){
              //  JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está guardando un archivo\n" + nombre,"Guardar",
                    //    1,null);
            //}
        } catch (AutomataException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        } catch (ClassNotFoundException e){
            System.out.println("Clase no encontrada");
        } catch (IOException e){
            System.out.println("El nombre de archivo, el nombre de directorio o la sintaxis de la etiqueta de volumen es incorrecta");
        } catch (Exception e){
            System.out.println("Nombre del archivo inválido");
        }

    }

    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void opcionGuardar(){
        try {
            archivos = new JFileChooser();
            archivos.showSaveDialog(this);
            String nombre = archivos.getSelectedFile()+"";
            //File archivosF =archivos.getSelectedFile();
            automata.guarde(nombre);
            //if (!nombre.equals(null+"")){
              //  JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está guardando un archivo\n" + nombre,"Guardar",
                //        1,null);
            //}
        } catch (AutomataException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        } catch (IOException e){
            System.out.println("El nombre de archivo, el nombre de directorio o la sintaxis de la etiqueta de volumen es incorrecta");
        } catch (Exception e){
            System.out.println("Nombre del archivo inválido");
        }

    }

    /**
     * Evento que se realiza cuando se da clic en el botón de guardar9
     * Genera un JFileChooser
     */
    private void opcionExportar(){

        try {
            archivos = new JFileChooser();
            archivos.showDialog(this, "Exportar");
            String nombre = archivos.getSelectedFile()+"";
            automata.exporte(nombre);
            //if (!nombre.equals(null+"")){
              //  JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está guardando un archivo\n" + nombre,"Guardar",
                //        1,null);
            //}
        } catch (AutomataException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        } catch (Exception e){
            System.out.println("Nombre del archivo inválido");
        }
    }

    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void opcionImportar(){
        try {
            archivos = new JFileChooser();
            archivos.showDialog(this, "Importar");
            String nombre = archivos.getSelectedFile()+"";
            automata = automata.importe(nombre);
            photo.repaint();
            //System.out.println(texto);
            //if (!nombre.equals(null+"")){
              //  JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está guardando un archivo\n" + nombre,"Guardar",
                //        1,null);
            //}
        } catch (AutomataException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo");
        } catch (IOException e){
            System.out.println("El nombre de archivo, el nombre de directorio o la sintaxis de la etiqueta de volumen es incorrecta");
        } catch (Exception e){
            System.out.println("Nombre del archivo inválido");
        }

    }
    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void opcionNuevo(){
        automata = automata.nuevo();
        repaint();

    }
    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void opcionSalir(){
        System.exit(0);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nuevo){
            //AutomataGUI game = new AutomataGUI();
            //game.setVisible(true);
            //game.setResizable(false);
            //game.setLocationRelativeTo(null);
            //dispose();
            opcionNuevo();
        }
        if(e.getSource() == abrir){
            opcionAbir();
        }
        if(e.getSource() == salvar){
            opcionGuardar();
        }
        if(e.getSource() == exportar){
            opcionExportar();
        }
        if(e.getSource() == importar){
            opcionImportar();
        }
        if(e.getSource() == salir){
            opcionSalir();
        }

    }


    /**
     * Crea un Item en una ubicacion específica de tipo Cell
     */
    protected void createNormal(int posX, int posY) {
        automata.someItems(posY,posX);
        automata.change(posY,posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Inquieta
     */
    protected void createInquieta(int posX, int posY) {
        automata.createInquieta(posY,posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Bulb
     */
    protected void createItemBulb(int posX, int posY) {
        automata.someItemBulb(posY,posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Colorin
     */
    protected void createItemColorin(int posX, int posY) {
        automata.someItemColorin("",posY,posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Person
     */
    protected void createItemPerson(int posX, int posY) {
        automata.someItemPerson("",posY,posX);
    }
    
    /**
     * Crea un Item en una ubicacion específica de tipo Conway
     */
    protected void createItemConway(int posX, int posY) {
        automata.someItemConway("",posY,posX);
    }
    
    /**
     * Crea un patrón específico (células Conway) dentro de la grilla
     * Se ingresa como parámetro la ubicación de la esquina izquierda superior
     */
    protected void createPatrones(int posX, int posY, String modelo) {
        automata.patrones(posY,posX, modelo);
    }
    
    /**
     * Se preparan todos los elementos visibles que pueden ser usados 
     */
    private void prepareElements() {
        setTitle("Automata celular");
        photo=new PhotoAutomata(this);
        buttonTicTac=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(buttonTicTac,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE,SIDE*SIZE+50)); 
        setResizable(false);
        prepareElementsMenu();
        photo.repaint();
    }
    
    /**
     * Se preparan la acción de pulsar un botón
     */
    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        buttonTicTac.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    buttonTicTacAction();
                }
            });

    }
    
    /**
     * Define la acción que ocurre detrás de pulsar un botón
     */
    protected void buttonTicTacAction() {
        automata.ticTac();
        photo.repaint();
    }
    
    /**
     * Retorna el automata de tipo CellularAutomata
     */
    public CellularAutomata getAutomata(){
        return automata;
    }
    
    /**
     * Función principal que se ejecuta
     */
    public static void main(String[] args) {
        AutomataGUI ca=new AutomataGUI();
        ca.setVisible(true);
    }  
}

class PhotoAutomata extends JPanel{
    private AutomataGUI gui;
    
    /**
     * Constructor de PhotoAutomata
     */
    public PhotoAutomata(AutomataGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE, gui.SIDE*gui.SIZE));         
    }
    /**
     * Dibuja todos los componentes de la aplicación
     */
    public void paintComponent(Graphics g){
        CellularAutomata automata=gui.getAutomata();
        super.paintComponent(g);
         
        for (int f=0;f<=automata.getLength();f++){
            g.drawLine(f*gui.SIDE,0,f*gui.SIDE,automata.getLength()*gui.SIDE);
        }
        for (int c=0;c<=automata.getLength();c++){
            g.drawLine(0,c*gui.SIDE,automata.getLength()*gui.SIDE,c*gui.SIDE);
        }       
        for (int f=0;f<automata.getLength();f++){
            for(int c=0;c<automata.getLength();c++){
                if (automata.getItem(f,c)!=null){
                    g.setColor(automata.getItem(f,c).getColor());
                    if (automata.getItem(f,c).shape()==Item.SQUARE){                  
                        if (automata.getItem(f,c).isAlive()){
                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);    
                        }
                    }else {
                        if (automata.getItem(f,c).isAlive()){
                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        } else {
                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        }
                    }
                }
            }
        }
    }
}

//Camilo es una mala persona :(