package tp02.ejercicio2;
import claseEstudiante.Estudiante;

public class TestListaEnlazadaGenerica {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante e1 = new Estudiante("Matias","Duran",23,"m@gmail","LP");
		Estudiante e2 = new Estudiante("Pedro","Viejo",19,"p@gmail","BS");
		Estudiante e3 = new Estudiante("Alfonso","Pico",56,"a@gmail","TU");
		Estudiante e4 = new Estudiante("Dibu","Martinez",99,"d@gmail","NE");
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		
		lista.agregarFinal(e1);
		lista.agregarFinal(e2);
		lista.agregarFinal(e3);
		lista.agregarFinal(e4);
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}
	}

}
