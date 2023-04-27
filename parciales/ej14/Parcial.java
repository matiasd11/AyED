package parciales.ej14;

import tp02.ejercicio2.*;
import tp04.ejercicio1.*;
public class Parcial {
	public ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> arbol){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<ListaGenerica<Integer>> camino = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
		resolver(arbol,lista,camino);
		return camino;
	}

	private void resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> l, ListaGenerica<ListaGenerica<Integer>> c) {
		// TODO Auto-generated method stub
		l.agregarFinal(a.getDato());
		if((a.esHoja()) && (a.getDato() < 0)) {
			ListaGenerica<Integer> aux = new ListaEnlazadaGenerica<Integer>();
			clonar(aux,l);
			c.agregarFinal(aux);
		}
		else {
			if((a.tieneHijos())) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				ArbolGeneral<Integer> aux;
				hijos.comenzar();
				while(!hijos.fin()) {
					aux = hijos.proximo();
					if(!(aux.getDato() > 0)) {
						resolver(aux,l,c);
						l.eliminarEn(l.tamanio());
					}
				}
			}
		}
	}
	private void clonar(ListaGenerica<Integer> aux, ListaGenerica<Integer> l) {
		l.comenzar();
		while(!l.fin()) {
			aux.agregarFinal(l.proximo());
		}
	}
}
