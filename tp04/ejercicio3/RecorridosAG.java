package tp04.ejercicio3;
import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.*;
public class RecorridosAG {
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(a,n,l);
		return l;
	}
	public void numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if((a.getDato() > n)&&(a.getDato() % 2 != 0)){
			l.agregarFinal(a.getDato());
		}
		if(a.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = a.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				numerosImparesMayoresQuePreOrden(lhijos.proximo(),n,l);
			
		}
	}
	public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(a,n,l);
		return l;
	}
	public void numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if(a.tieneHijos()) {
			ListaGenerica <ArbolGeneral<Integer>> lhijos = a.getHijos();
			lhijos.comenzar();
			while (!lhijos.fin()) 
				numerosImparesMayoresQuePostOrden(lhijos.proximo(),n,l);
			
		}
		if((a.getDato() > n)&&(a.getDato() % 2 != 0)){
			l.agregarFinal(a.getDato());
		}
		
	}
	public ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(a,n,l);
		return l;
	}
	public void numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		ListaGenerica <ArbolGeneral<Integer>> lhijos = a.getHijos();
		lhijos.comenzar();
		if (!lhijos.esVacia())
			numerosImparesMayoresQueInOrden(lhijos.proximo(),n,l);
		if (((a.getDato() % 2) == 1) && (a.getDato() > n )) 
			l.agregarFinal(a.getDato());
		while (!lhijos.fin() && !lhijos.esVacia()) {
			numerosImparesMayoresQueInOrden(lhijos.proximo(),n,l);
		}
	}
	public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> c = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		c.encolar(a);
		while(!c.esVacia()) {
			aux = c.desencolar();
			if (((aux.getDato() % 2) == 1) && (aux.getDato() > n )) 
				l.agregarFinal(aux.getDato());
			if(aux.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> lHijos = aux.getHijos();
				lHijos.comenzar();
				while(!lHijos.fin()) {
					c.encolar(lHijos.proximo());
				}
			}
		}
		return l;
	}
}
