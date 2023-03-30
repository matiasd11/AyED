package tp02.ejercicio1;

public class EnInversa {
	
	public static void inverso(ListaDeEnteros lista, int actual) {
		if (actual <= lista.tamanio()) {
			inverso(lista, actual+1);
			System.out.println(lista.elemento(actual));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosConArreglos obj1 = new ListaDeEnterosConArreglos();
		ListaDeEnterosEnlazada obj2 = new ListaDeEnterosEnlazada();
		if (args.length  == 0){
	       	 System.out.println("El programa se ejecutó sin parametros");
	    }else if (args.length > 1) {
    		int num = 0;
    		Integer numero;
        	while (num < args.length) {
			numero = Integer.parseInt(args[num]);
			num++;
			obj1.agregarFinal(numero);
			obj2.agregarFinal(numero);
        	}
		}
		System.out.println("Arreglo");
		obj1.comenzar();
		while (!obj1.fin()) {
			System.out.println(obj1.proximo());
		}
		System.out.println("Arreglo inverso");
		inverso(obj1, 1);
		System.out.println("Enlazada");
		obj2.comenzar();
		while (!obj2.fin()) {
			System.out.println(obj2.proximo());
		}
		System.out.println("Enlazada inversa");
		inverso(obj2, 1);
		
	}

}
