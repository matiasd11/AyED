package parciales.ej9;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ProcesadorGematria {
	public int contar(ArbolGeneral<Integer> a, int valor) {
		int suma = valor - a.getDato();
		
		if((a.esHoja())&& (suma == 0)) {
			return 1;
		}
		else {
			int cant = 0;
			if((a.tieneHijos()) && (suma > 0)) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cant += contar(hijos.proximo(),suma);
				}
			}
			return cant;
		}
		
	}
}
