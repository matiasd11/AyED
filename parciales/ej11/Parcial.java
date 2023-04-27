package parciales.ej11;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	public boolean esArbolCreciente(ArbolBinario<Integer> arbol) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux;
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		int cant = 0;
		boolean ok = true;
		while(!cola.esVacia() && ok) {
			aux = cola.desencolar();
			if(aux != null) {
				cant++;
				if(aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
				if(aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
			}
			else {
				if(cant != nivel + 1) {
					ok = false;
				}
				if(!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
					cant = 0;
				}
			}
		}
		return ok;
	}
}
