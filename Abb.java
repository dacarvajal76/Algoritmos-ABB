package com.ucab.abb;

public class Abb {
	private Nodo raiz;
	
	public Abb (){ //contructor1
		raiz=null;
	}
	public Abb(Nodo raiz) {	//constructor2
	 this.raiz = raiz;
	}
	
	public void insertar(int valorInsertar){
		if(raiz == null)
			 raiz = new Nodo(valorInsertar);
		else
			raiz.insertar(valorInsertar);
	}
	
	public void recorridoPreorden() {
        ayudantePreorden(raiz);
    }
	
	private int Altura(Nodo raiz) {			
			if (raiz == null) {
				return 0;
			}
			
			return 1 + Math.max(Altura(raiz.getHijoIzquierdo()), Altura(raiz.getHijoDerecho()));
		
	}
	
	public void imprimirAltura() {
		int altura;
		altura = Altura(raiz);
		System.out.println(altura);
	}
	
	private int ContarNodosGestionador(Nodo raiz) {
		int suma = 0;
		if(raiz != null) suma = ContarNodos(raiz);
		return suma;
	}
	
	private int ContarNodos(Nodo raiz) {
		int suma = 1;
		if(raiz.getHijoIzquierdo()!=null)suma += ContarNodos(raiz.getHijoIzquierdo());
		if(raiz.getHijoDerecho()!=null)suma += ContarNodos(raiz.getHijoDerecho());
		return suma;
	}
	
	public void imprimirContarNodos() {
		System.out.println(ContarNodosGestionador(raiz));
	}
	
	private int AgregarNodo(Nodo raiz) {
		if(raiz.getHijoIzquierdo() ==null) {
			Nodo nodo = new Nodo();
			raiz.setHijoIzquierdo(nodo);
			return 1;			
		}else if(raiz.getHijoDerecho() ==null){
			Nodo nodo = new Nodo();
			raiz.setHijoDerecho(nodo);
			return 1;	
		}		
		if(AgregarNodo(raiz.getHijoIzquierdo()) == 1)return 1;
		if(AgregarNodo(raiz.getHijoDerecho()) == 1)return 1;
		return 1;
	}
	
	private void NuevoNivel(Nodo raiz) {
		if(raiz.getHijoIzquierdo()==null) {
			Nodo nodo = new Nodo();
			raiz.setHijoIzquierdo(nodo);
		}else {
			NuevoNivel(raiz.getHijoIzquierdo());
		}
	}
	
	public int gestionInsertar() {
		if(raiz==null) {
			Nodo nodo = new Nodo();
			raiz = nodo;
			return 1;
		}
		if(ContarNodosGestionador(raiz) < 32) {
			if(Altura(raiz) == 1) {
				Nodo nodo = new Nodo();
				raiz.setHijoIzquierdo(nodo);
				return 1;
			}
			if(ContarNodosGestionador(raiz) == 3 || ContarNodosGestionador(raiz) == 6 || ContarNodosGestionador(raiz) == 15) {
				NuevoNivel(raiz);
				return 1;
			}else {
				AgregarNodo(raiz);
				return 1;
			}
		}
		return 1;
	}

    private void ayudantePreorden(Nodo raiz) {
        if (raiz == null) 
            return;
        System.out.println(raiz.getDato());
        ayudantePreorden(raiz.getHijoIzquierdo());
        ayudantePreorden(raiz.getHijoDerecho());
    }

    public void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    private void ayudanteInorden(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        ayudanteInorden(raiz.getHijoIzquierdo());
        System.out.print(raiz.getDato()+ ",");
        ayudanteInorden(raiz.getHijoDerecho());
    }

    public void recorridoPostorden() {
        ayudantePostorden(raiz);
    }

    private void ayudantePostorden(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        ayudantePostorden(raiz.getHijoIzquierdo());
        ayudantePostorden(raiz.getHijoDerecho());
        System.out.println(raiz.getDato());
    }
    
    public int esHoja(){
    	return Hoja(raiz);
    }
    
    private int Hoja (Nodo raiz){
    	if(raiz !=null){
    		if ((raiz.getHijoIzquierdo()== null)&&(raiz.getHijoDerecho()== null))
    			return 1;
    		else 
    			return Hoja(raiz.getHijoIzquierdo()) + Hoja(raiz.getHijoDerecho());
    	}
		return 0;
    }
    
    public int cantRamas(){
    	return Ramas(raiz)-1;
    }
    
    private int Ramas(Nodo raiz){
    	if (raiz!=null){
    		if((raiz.getHijoIzquierdo()== null)&&(raiz.getHijoDerecho()== null))
    			return 1;
    		else {
    			int ramaIzq=Ramas(raiz.getHijoIzquierdo());
    			int ramaDer=Ramas(raiz.getHijoDerecho());
    			return 1+ramaIzq+ramaDer;
    		}
    	}
		return 0;    
    }   
    
    public boolean removeNodo( Nodo nodo ) {

        /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = nodo.getHijoIzquierdo() != null ? true : false;
        boolean tieneNodoIzquierda = nodo.getHijoIzquierdo() != null ? true : false;

        /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */

        /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }

        /* Caso 2: Tiene un hijo y el otro no */
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }

        /* Caso 2: Tiene un hijo y el otro no */
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }

        /* Caso 3: Tiene ambos hijos */
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }

        return false;
    }
 
    
    private boolean removeNodoCaso1( Nodo nodo ) {
        /* lo único que hay que hacer es borrar el nodo y establecer el apuntador de su padre a nulo */

        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        Nodo hijoIzquierdo = nodo.getPadre().getHijoIzquierdo();
        Nodo hijoDerecho = nodo.getPadre().getHijoIzquierdo();

        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHijoIzquierdo( null );
            return true;
        }

        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHijoIzquierdo( null );
            return true;
        }

        return false;
    }
  
    private boolean removeNodoCaso2( Nodo nodo ) {
        /* Borrar el Nodo y el subárbol que tenía pasa a ocupar su lugar */

        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        Nodo hijoIzquierdo = nodo.getPadre().getHijoIzquierdo();
        Nodo hijoDerecho = nodo.getPadre().getHijoIzquierdo();

        /*
         * Buscamos el hijo existente del nodo que queremos eliminar
         */
        Nodo hijoActual = nodo.getHijoIzquierdo() != null ? 
                nodo.getHijoIzquierdo() : nodo.getHijoIzquierdo();

        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHijoIzquierdo( hijoActual );

            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHijoIzquierdo(null);
            nodo.setHijoIzquierdo(null);

            return true;
        }

        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHijoIzquierdo( hijoActual );

            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHijoIzquierdo(null);
            nodo.setHijoIzquierdo(null);

            return true;
        } 

        return false;
    }
    private boolean removeNodoCaso3( Nodo nodo ) {
        /* Tomar el hijo derecho del Nodo que queremos eliminar */
        Nodo nodoMasALaIzquierda = recorrerIzquierda( nodo.getHijoIzquierdo() );
        if ( nodoMasALaIzquierda != null ) {
            /*
             * Reemplazamos el valor del nodo que queremos eliminar por el nodo que encontramos 
             */
        //    nodo.setValor( nodoMasALaIzquierda.getValor() );
            /* 
             * Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
             */
            removeNodo( nodoMasALaIzquierda );
            return true;
        }
        return false;
    }

    /* Recorrer de forma recursiva hasta encontrar el nodo más a la izquierda */
    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHijoIzquierdo() != null) {
            return recorrerIzquierda( nodo.getHijoIzquierdo() );
        }
        return nodo;
    }
    
}
