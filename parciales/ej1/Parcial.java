package parciales.ej1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {

	public ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character> arbol){
		ListaGenerica<ListaGenerica<Character>> lista = new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		int cant = 0;
		ListaGenerica<Character> listaC = new ListaEnlazadaGenerica<Character>();
		listaC.agregarFinal(arbol.getDato());
		caminosPares(arbol,lista,listaC,cant);
		return lista;
	}
	public void caminosPares(ArbolGeneral<Character> a,ListaGenerica<ListaGenerica<Character>> l,ListaGenerica<Character> lC, int cant) {
		cant++;
		if(a.esHoja()) {
			if(cant % 2 == 0) {
				l.agregarFinal(lC.clonar());
			}
		}
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Character>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {	
				ArbolGeneral<Character> aux = hijos.proximo();
				lC.agregarFinal(aux.getDato());
				caminosPares(aux,l,lC,cant);
				lC.eliminarEn(lC.tamanio());
			}
		}
	}
}
