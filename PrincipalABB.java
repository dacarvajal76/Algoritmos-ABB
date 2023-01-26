package com.ucab.abb;

import javax.swing.JOptionPane;

public class PrincipalABB {

	  public static void main(String args []){
          Abb arbol = new Abb();
          int valor;
          String Dato;
          /*
          System.out.println("Insertando los siguientes valores: ");
          
          Dato = JOptionPane.showInputDialog("Inserta el numero de nodos que desea ingresar");
          int n = Integer.parseInt(Dato);
          
          for(int i = 1; i <= n; i++ ){
              Dato = JOptionPane.showInputDialog("Dame el valor del nodo " + i + " para colocar en el Arbol");
              valor = Integer.parseInt(Dato);
              System.out.print(valor + " ");
              arbol.insertar(valor);
          }
                    
          System.out.println("\n\nRecorrido Preorden");
          arbol.recorridoPreorden();
          

          System.out.println("\n\nRecorrido Inorden");
          arbol.recorridoInorden();

          System.out.println("\n\nRecorrido Postorden");
          arbol.recorridoPostorden();
          System.out.println();
          */
          
          arbol.gestionInsertar();arbol.gestionInsertar();arbol.gestionInsertar();
          
          arbol.imprimirAltura();
          arbol.imprimirContarNodos();
          
	  }

}
