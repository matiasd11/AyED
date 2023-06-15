package tp06.ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		boolean[] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
		Vertice<String> v = null;
		ListaGenerica<Vertice<String>> aux = lugares.listaDeVertices();
		for(int i = 1; i < lugares.listaDeVertices().tamanio() + 1; i++) {
			if(lugaresRestringidos.incluye(lugares.listaDeVertices().elemento(i).dato())){
				marca[i] = true;
			}
		}
		aux.comenzar();
		boolean ok = false;
		int i = -1;
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if(v.dato().equals("Ayuntamiento")) {
				ok = true;
				i = v.getPosicion();
			}
		}
		if(ok) {
			paseoEnBici(i,lugares,destino,maxTiempo,lugaresRestringidos,marca,lista,camino);
		}
		return camino;
	}
	private void paseoEnBici(int i,Grafo<String> lugares, String destino, int maxTiempo,ListaGenerica<String> lugaresRestringidos,boolean[] marca, ListaGenerica<String> l,ListaGenerica<String> c) {
		marca[i] = true;
		Vertice<String> v = lugares.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		if(v.dato().equals(destino) && c.esVacia() && maxTiempo >= 0) {
			clonar(c,l);
		}else {
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && c.esVacia()) {
				Arista<String> aux = ady.proximo();
				int j = aux.verticeDestino().getPosicion();
				if(!marca[j] && maxTiempo - aux.peso() >= 0) {
					paseoEnBici(j,lugares,destino,maxTiempo - aux.peso(),lugaresRestringidos,marca,l,c);
					marca[j] = false;
					l.eliminarEn(l.tamanio());
				}
			}
		}
	}
	private void clonar(ListaGenerica<String> c,ListaGenerica<String> l) {
		l.comenzar();
		while(!l.fin()) {
			c.agregarFinal(l.proximo());
		}
	}
}
