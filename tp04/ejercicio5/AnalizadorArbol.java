package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>a) {
		ColaGenerica<ArbolGeneral<AreaEmpresa>> c = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> aux;
		c.encolar(a);
		c.encolar(null);
		int total = 0, cant = 0, promedio, max = -1;
		while(!c.esVacia()) {
			aux = c.desencolar();
			if (aux != null) {
				total += aux.getDato().getTardanza();
				cant++;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> lHijos = aux.getHijos();
					lHijos.comenzar();
					while(!lHijos.fin()) {
						c.encolar(lHijos.proximo());
					}
				}
				
			}
			else {
				promedio = total / cant;
				max = Math.max(max, promedio);
				total = 0;
				cant = 0;
				if(!c.esVacia()) {
					c.encolar(null);
				}
			}
	
			
		}
		return max;
	}
}
