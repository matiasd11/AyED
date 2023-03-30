package tp02.ejercicio1;

public class Ejercicio1_6 {
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		lista.agregarFinal(n);
		if(n != 1) {
			if(n % 2 == 0) {
				calcularSucesion(n/2);
			}else {
				calcularSucesion(3*n + 1);
			}
		}
		return lista;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio1_6 f = new Ejercicio1_6();
		
		ListaDeEnterosEnlazada l = f.calcularSucesion(6);
		
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}

}
