package parciales.ej4;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	private ArbolGeneral<Integer> arbol;
	
	
	
	public Parcial(ArbolGeneral<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	public ListaGenerica<Integer> caminoLargo(){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();
		caminoLargo(this.arbol,lista,camino);
		return camino;
	}
	public void caminoLargo(ArbolGeneral<Integer> a,ListaGenerica<Integer> l,ListaGenerica<Integer> camino) {
		if(!a.esVacio()) {
			l.agregarFinal(a.getDato());
			if(a.esHoja()) {
				if(l.tamanio() > camino.tamanio()) {
					clonar(l, camino);
				}
			}
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					caminoLargo(hijos.proximo(),l,camino);
					l.eliminarEn(l.tamanio());
				}
			}
		}
	}
	private void clonar (ListaGenerica<Integer> l, ListaGenerica<Integer> camino) {
			camino.comenzar();
			while(!camino.fin())
				camino.eliminar(camino.proximo());
			l.comenzar();
			while(!l.fin())
				camino.agregarFinal(l.proximo());
				
		}
	}

