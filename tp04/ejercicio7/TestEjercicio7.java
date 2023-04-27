package tp04.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TestEjercicio7 {

	public static void main(String[] args) {
		ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> n = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> o = new ArbolGeneral<Integer>(15);
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		d.agregarHijo(o);
		
		j.agregarHijo(m);
		j.agregarHijo(n);
		
		
		RedDeAguaPotable test = new RedDeAguaPotable(a);
		
		System.out.println("MINIMO : "+ Math.round(test.minimoCaudal(1000.00)));
		
		//System.out.println("MINIMO : "+ test.minimoCaudal2(1000.00));
		
	}

}