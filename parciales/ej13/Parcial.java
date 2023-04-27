package parciales.ej13;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	ArbolGeneral<Integer> arbol;

	public Parcial(ArbolGeneral<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public Integer buscarMayorEnPostOrden() {
		return buscarMayorEnPostOrden(arbol);
	}
	
	public Integer buscarMayorEnPostOrden(ArbolGeneral<Integer> arbol) {
		int max = Integer.MIN_VALUE;
		if(arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			hijos.comenzar();		
			while(!hijos.fin()) {
				 max = Math.max(max, buscarMayorEnPostOrden(hijos.proximo())); 
			}
			if(arbol.getDato()> max) {
				max = arbol.getDato();
			}
		}
		return max;
	}
}
