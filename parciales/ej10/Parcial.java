package parciales.ej10;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	
	public ListaGenerica<String> camino(ArbolGeneral<String> a){
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> c = new ListaEnlazadaGenerica<String>();
		camino(a,lista, c);
		return c;
	}
	public void camino(ArbolGeneral<String> a,ListaGenerica<String> l, ListaGenerica<String> c) {
		l.agregarFinal(a.getDato());
		if (a.getDato().equals("princesa")) {
			 clonar(l, c);
			}
		if (c.esVacia()) {
			ListaGenerica<ArbolGeneral<String>> lHijos = a.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin() && c.esVacia()) {
				ArbolGeneral<String> aux = lHijos.proximo();
				if (!aux.getDato().equals("dragon")) {
					camino(aux, l, c);
					l.eliminarEn(l.tamanio());
				}
			}
		}
	}
	private void clonar(ListaGenerica<String> l, ListaGenerica<String> camino) {
		l.comenzar();
		while(!l.fin())
			camino.agregarFinal(l.proximo());
	}

}
