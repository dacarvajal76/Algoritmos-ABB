package com.ucab.abb;

public class Nodo {

	private int dato;
	private Nodo hijoDerecho;
	private Nodo hijoIzquierdo;
	
	/**
	* Constructor
	* @param clave descripción entero
	*/		
	public Nodo(int clave){
		dato=clave;
		hijoIzquierdo = hijoDerecho = null;
	}
	
	public Nodo() {
		hijoIzquierdo = hijoDerecho = null;
	}
	
	/**
	* Método getter del atributo dato que representa la clave
	* @return un x que representa la clave
	*/	
	public int getDato() {		
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	/**
	* Método PARA <b>INSERTAR</b> un nodo en el arbol, el objeto que llama
	* a este método tiene el dato por el cual va a comparar con la clave
	* a insertar. Dependiendo de su valor ira por el camino izquierdo o derecho.
	* @param entero valorInsertar representa el valor de la clave que quiero insertar en el arbol ABB
	* @return un entero que representa la clave
	*/	
	public void insertar(int valorInsertar) {
		if(dato > valorInsertar){
			if (hijoIzquierdo == null)
				hijoIzquierdo = new Nodo(valorInsertar);
			else
			  hijoIzquierdo.insertar(valorInsertar);
		}
		else if (dato < valorInsertar){
				if(hijoDerecho == null)
					hijoDerecho= new Nodo(valorInsertar);
				else
					hijoDerecho.insertar(valorInsertar);
			}
	}
	
	private void eliminar(Nodo n){}
	
	public Nodo getPadre() {
		return null;
	}
	
	public void setPadre(Nodo nodo) {

	}	
}