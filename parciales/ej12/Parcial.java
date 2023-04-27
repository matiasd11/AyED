package parciales.ej12;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	ArbolBinario<Integer> arbol;

	public Parcial(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public ArbolBinario<Integer> minEnNivelDeAB(int n) {
		ColaGenerica<ArbolBinario<Integer>> c = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux;
		c.encolar(arbol);
		c.encolar(null);
		int nivel = 0;
		int minN = Integer.MAX_VALUE;
		ArbolBinario<Integer> min = null;
		while(!c.esVacia() && nivel <= n) {
			aux = c.desencolar();
			if(aux != null) {
				if(nivel == n && aux.esHoja() && aux.getDato() < minN) {
					minN = aux.getDato();
					min = aux;
				}
				if(aux.tieneHijoIzquierdo()) {
					c.encolar(aux.getHijoIzquierdo());
				}
				if(aux.tieneHijoDerecho()) {
					c.encolar(aux.getHijoDerecho());
				}
			}
			else if(!c.esVacia()){ 
				nivel++;
				c.encolar(null);
			}
		}
		return min;
	}
}
