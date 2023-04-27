package parciales.ej7;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public void colorearArbol(ArbolBinario<String> arbol,Integer n, Integer m) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol!= null){
				if ((nivel < n) || (nivel > m)) {
					arbol.setDato("Negro");
				} else {
						arbol.setDato("Rojo");
				}
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;	
			}
		}
	}
}
