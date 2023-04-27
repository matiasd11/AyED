package p3;

public class Parcial {
	ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	
	public Parcial(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	public boolean resolver(int k) {
		return resolver(k, this.arbol);
	}
	public boolean resolver(int k, ArbolBinario<Integer> a) {
		boolean ok = true;
		int resta = k - a.getDato();
		if((!a.esVacio())) {
			if(a.esHoja()) {
				System.out.println(resta);
				if(resta == 0) {
					return true;
				}else {
					return false;
				}
			}else {
				if(a.tieneHijoIzquierdo()) {
					if(!resolver(resta, a.getHijoIzquierdo())) {
						ok = false;
					}
				}
				if(a.tieneHijoDerecho()) {
					if(!resolver(resta, a.getHijoDerecho())) {
						ok = false;
					}
				}
			}
			return ok;
		}else {
			return false;
		}
	}
}
