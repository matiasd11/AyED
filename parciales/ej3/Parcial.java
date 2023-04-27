package parciales.ej3;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	ArbolGeneral<Integer> arbol;
	
	public Parcial(ArbolGeneral<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		postOrder(lista,this.arbol);
		return lista;
	}
	public void postOrder(ListaGenerica<Integer> l, ArbolGeneral<Integer> a) {
		int suma = 0;
		if(!a.esVacio()) {
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					ArbolGeneral<Integer> aux = hijos.proximo();
					suma += aux.getDato();
					postOrder(l,aux);
				}
				if(hijos.tamanio() % 2 == 1) {
					l.agregarFinal(suma);
				}
			}
		}
	}
}
