package tp04.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		 ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		 this.preOrden(lis);
		 return lis;
	}
	private void preOrden(ListaGenerica<T> l) {
		l.agregarFinal(this.getDato());
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
		lHijos.comenzar();
		while (!lHijos.fin()) {
		 (lHijos.proximo()).preOrden(l);
		}
	}

	
	public Integer altura() {
		// Falta implementar..
		int altura = 0;
		if(this.esHoja()) {
			return 0;
		}
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin())
				altura = Math.max(altura,lhijos.proximo().altura());
		}
		return altura + 1;
	}

	public Integer nivel(T dato) {
		// falta implementar
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		int nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.getDato() == dato)
					return nivel;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()){
						cola.encolar(lhijos.proximo());
					}
				}
			}
			else
				if (!cola.esVacia()) {			
					cola.encolar(null);
					nivel++;
				}
		}
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		int cantidad=0,max = -1, nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cantidad++;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin())
						cola.encolar(lhijos.proximo());
				}
			}
			else {					
				if(cantidad > max)
					max = cantidad;
				cantidad=0;		
				if (!cola.esVacia()) {			
					cola.encolar(null);
					nivel++;

				}
			}
		}
		return max;
	}
	public ArbolGeneral<T> buscarA(T a){
		if((this.getDato() == a)){
			System.out.println("Encontrado");
			return this;
		}
		if(this.tieneHijos()) {
			 ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
		     lhijos.comenzar();
		     while (!lhijos.fin()) {
		        ArbolGeneral<T> nodoEncontrado = lhijos.proximo().buscarA(a);
		        if (nodoEncontrado != null) {
		            return nodoEncontrado;
                }
		     }
			
		}
		return null;
	}
	public Boolean esAncestro(T a, T b) {
		ArbolGeneral<T> arbolA = this.buscarA(a);
		if(arbolA == null){
			System.out.println("Null");
			return false;
		}
		return arbolA.esAncestro(b);
	}
	public Boolean esAncestro(T b) {
		System.out.println(this.getDato());
		if(this.getDato() == b) {
			return true;
		}
		if (this.tieneHijos()){
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				if(lHijos.proximo().esAncestro(b)) {
					return true;
				}
	        }
	    }
	    return false;
	}
	

}