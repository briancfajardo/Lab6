package domain;
import java.awt.Color;
import java.io.Serializable;

/**
 * Item es una interfaz que recoge los comportamientos de los objetos
 * que pueden decidir, son redondos o cuadrados, tienen un color e inician
 * muertos
 * 
 * @author Camilo Fajardo
 * @author Andrea Durán
 * @version 19/03/2022
 */

public interface Item extends Serializable {
  int ROUND = 1;
  int SQUARE = 2;
  
  /**
    * @abstract
    * Decide its next state
    */
  void decide();
   
  /**
    * Decide its state
    */
  default void change(){
  };
  
  /**
    * Retorna los vecinos muertos
    */
  default int getMuertas(){
      return 0;
  };
  
  /**
    * Retorna su forma
    */
  default int shape(){
      return ROUND;
  }
  
  /**
    * Retorna su color
    */
  default Color getColor(){
      return Color.black;
  };
  
  /**
    * Retorna si está vivo
    */
  default boolean isAlive(){
      return false;
  }
  
}
