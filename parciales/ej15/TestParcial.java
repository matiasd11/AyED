package p3;

public class TestParcial {
	public static void main(String[] args) {
		ArbolBinario<Integer> a = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> b = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> c = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> d = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> e = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> f = new ArbolBinario<Integer> (1);
		ArbolBinario<Integer> g = new ArbolBinario<Integer> (1);
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		
		c.agregarHijoIzquierdo(g);
		
		c.agregarHijoDerecho(f);
		
		
		Parcial test = new Parcial(a);
		
		System.out.println(test.resolver(3));
		}
}
