package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<Integer> arbol;

	public RedDeAguaPotable(ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal (double caudal) {
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ColaGenerica<Double> colaCaudal = new ColaGenerica<Double>();
		ArbolGeneral<Integer> aux;
		double auxCaudal;
		
		int nivel = 0;
		double min = 99999.9;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		colaCaudal.encolar(caudal);
		colaCaudal.encolar(0.0);
		
		System.out.println("NIVEL "+nivel+" : ");
		while (!cola.esVacia()) {
			int cantidad = 0;
			
			aux = cola.desencolar();
			auxCaudal = colaCaudal.desencolar();
			
			if (aux != null) {				
				System.out.println("NODO: "+ aux.getDato() + " CAUDAL: " + auxCaudal);
				if (auxCaudal < min)
					min = auxCaudal;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin()) {
						cantidad++;
						cola.encolar(lhijos.proximo());
					}
					auxCaudal = auxCaudal / (double) cantidad;
				}
				else 
					auxCaudal = 0.0;
				for (int i= 0; i < cantidad; i++)
					colaCaudal.encolar(auxCaudal);	

			}
		else
			if (!cola.esVacia()) {
				cola.encolar(null);
				colaCaudal.encolar(0.0);
				nivel++;
				System.out.println("NIVEL "+nivel+" : ");
			}	
		}
		System.out.println(" ");
		return min;
	}
	
	public double minimoCaudal2(double caudal) {
		return minimoCaudal2(caudal,arbol);
	}
	
	private double minimoCaudal2 (double caudal,ArbolGeneral<Integer> a) {
		double min = 9999.99;
		if (a.esHoja()) {
			System.out.println("NODO: "+ a.getDato()+" CAUDAL: "+ caudal);
			return caudal;
		}
		if(a.tieneHijos()) {
			System.out.println("NODO: "+ a.getDato()+" CAUDAL: "+ caudal);
			ListaGenerica<ArbolGeneral<Integer>> l = a.getHijos();
			caudal = caudal /(double) l.tamanio();
			l.comenzar();
			while (!l.fin()) {
				min = Math.min(min,minimoCaudal2(caudal,l.proximo()));
			}
		}
		return min;
	}
	
}
