package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
	public ListaGenerica<T> dfs(Grafo<T> grafo){
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for(int i= 1; i < grafo.listaDeVertices().tamanio();i++) {
			if(!marca[i]) {
				dfs(i,grafo,lista,marca);
			}
		}
		return lista;
	}
	private void dfs(Integer i, Grafo<T> grafo, ListaGenerica<T> l, boolean [] marca) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<T> arista = ady.proximo();
			int j = arista.verticeDestino().getPosicion();
			if (!marca[j])
				dfs(j,grafo,l,marca);
		}

	}
	public ListaGenerica<T> bfs(Grafo<T> grafo){
		boolean[]marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		ListaGenerica<T> lis = new ListaEnlazadaGenerica<>();
		for (int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				bfs(i,grafo,lis,marca);
		}
		return lis;
	}
	private void bfs(Integer i, Grafo<T> grafo, ListaGenerica<T> lis, boolean [] marca) {
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
		cola.encolar(grafo.listaDeVertices().elemento(i));
		marca[i]= true;
		while(!cola.esVacia()) {
			Vertice <T> v = cola.desencolar();
			lis.agregarFinal(v.dato());
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					cola.encolar(arista.verticeDestino());
					marca[j] = true;
				}
			}
		}
	}
}
