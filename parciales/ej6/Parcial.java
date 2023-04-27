package parciales.ej6;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public void colorearArbol(ArbolBinario<String> arbol,Integer maxColor) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		int cantN = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol!= null){
				if ((nivel % 2 == 0) && (cantN < maxColor)) {
					arbol.setDato("Negro");
					cantN++;
				} else {
					if((nivel % 2 == 1) && (cantN < maxColor)) {
						arbol.setDato("Rojo");
						cantN++;
					}
					else {
						arbol.setDato("Verde");
					}
				}
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;	
				cantN = 0;
			}
		}
	}
}
