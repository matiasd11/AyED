package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class RecorridosTest {
	public static void main(String[] args) {
		Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<>("La Habana");

		Grafo<String> ciudades = new GrafoImplListAdy<>();

		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);

		ciudades.conectar(v1, v2);
		ciudades.conectar(v1, v3);
		ciudades.conectar(v1, v4);
		ciudades.conectar(v1, v5);
		ciudades.conectar(v2, v5);
		ciudades.conectar(v2, v7);
		ciudades.conectar(v3, v5);
		ciudades.conectar(v4, v5);
		ciudades.conectar(v6, v5);
		ciudades.conectar(v6, v7);


		Recorridos<String> r = new Recorridos<>();

		System.out.println(" ");
		System.out.println("--- Se imprime el GRAFO con DFS2 ---");
		ListaGenerica <String> lis3 = r.dfs(ciudades);
		lis3.comenzar();
		while(!lis3.fin()) {
			System.out.println(lis3.proximo());
		}
		System.out.println(" ");
		System.out.println("--- Se imprime el GRAFO con BFS2 ---");
		ListaGenerica <String> lis4 = r.bfs(ciudades);
		lis4.comenzar();
		while(!lis4.fin()) {
			System.out.println(lis4.proximo());
		}

	}
}
