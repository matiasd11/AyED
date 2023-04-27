package parciales.ej5;

import tp02.ejercicio2.*;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		resolver(arbol,lista);
		return lista;
	}
	public Integer resolver(ArbolBinario<Integer> a,ListaGenerica<Integer> l) {
		int cantI = 0, cantD = 0;
		if(!a.esVacio()) {
			if(a.esHoja()) {
				l.agregarFinal(a.getDato());
			}
			else {
				if(a.tieneHijoIzquierdo()) {
					cantI += resolver(a.getHijoIzquierdo(),l);
				}
				if(a.tieneHijoDerecho()) {
					cantD += resolver(a.getHijoDerecho(),l);
				}
				if(cantI == cantD){
					l.agregarFinal(a.getDato());
				}
			}
			return cantI + cantD + 1;
		}
		return -1;
	}
}
