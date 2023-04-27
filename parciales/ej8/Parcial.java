package parciales.ej8;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public ListaGenerica<ArbolGeneral<Integer>> resolver(ArbolGeneral<Integer> arbol){
		ListaGenerica<ArbolGeneral<Integer>> lista  = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		resolver(arbol,lista);
		return lista;
	}
	public void resolver(ArbolGeneral<Integer> a,ListaGenerica<ArbolGeneral<Integer>> l) {
		if(!a.esVacio()) {
			l.agregarFinal(a);
			if(a.tieneHijos()) {
				int pos = a.getDato();
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				resolver(hijos.elemento(pos),l);
			}
		}
	}
}
