package tp06.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
	Grafo<String> mapaCiudades;
	public Mapa (Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	public ListaGenerica<String> devolverCamino(String ciudad1,String ciudad2){
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		boolean [] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = this.mapaCiudades.listaDeVertices();
		aux.comenzar();
		Vertice<String> v;
		boolean ok = false;
		int i = -1;
		while(!aux.fin() && !ok ) {
			v = aux.proximo();
			if(v.dato().equals(ciudad1)) {
				i = v.getPosicion();
				
				ok = true;
			}
		}
		if(ok) {
			dfs(i,this.mapaCiudades,lista,camino,marca,ciudad2);
		}
		return camino;
	}
	private boolean dfs(Integer i, Grafo<String> grafo, ListaGenerica<String> l,  ListaGenerica<String> c, boolean [] marca, String ciudad2) {
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		boolean ok = false;
		while(!ady.fin() && !ok) {
			Arista<String> arista = ady.proximo();
			int j = arista.verticeDestino().getPosicion();
			if(arista.verticeDestino().dato().equals(ciudad2)) {
				l.agregarFinal(arista.verticeDestino().dato());
				ok = true;
				clonar(c,l);
			}
			if (!marca[j] && !ok) {
				ok = dfs(j,grafo,l,c,marca,ciudad2);
				l.eliminarEn(l.tamanio());
			}
		}
		return ok;

	}
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		boolean [] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = this.mapaCiudades.listaDeVertices();
		for(int i= 1; i < this.mapaCiudades.listaDeVertices().tamanio();i++) {
			if(ciudades.incluye(this.mapaCiudades.listaDeVertices().elemento(i).dato())) {
				marca[i] = true;
			}
		}
		aux.comenzar();
		Vertice<String> v;
		boolean ok = false;
		int i = -1;
		while(!aux.fin() && !ok ) {
			v = aux.proximo();
			if(v.dato().equals(ciudad1)) {
				i = v.getPosicion();
				
				ok = true;
			}
		}
		if(ok) {
			dfs(i,this.mapaCiudades,lista,camino,marca,ciudad2);
		}
		return camino;
	}
	public ListaGenerica<String> caminoMasCorto2 (String ciudad1, String ciudad2){
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		
		Vertice<String> v = null;
		boolean ok = false;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals(ciudad1));
				ok = true;
		}
		if (ok) {
			int distancia = 0;
			caminoMasCorto2(v.getPosicion(),camino,marca,ciudad2,distancia,lis);
		}
		return camino;
	}
	
	private Integer caminoMasCorto2 (int i, ListaGenerica<String> camino, boolean[]marca, String destino, int distancia,ListaGenerica<String> lis) {
		marca[i] = true;
		int min = 9999;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		lis.agregarFinal(v.dato());
		if (v.dato().equals(destino) && distancia < min) {
			clonar2(lis,camino);
			return distancia;
		}else{
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					distancia += arista.peso();
					min = caminoMasCorto2(j,camino,marca,destino,distancia,lis);
					lis.eliminarEn(lis.tamanio());
					marca[j] = false;
				}
			}
		}
		return min;
		
	}
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		
		Vertice<String> v = null;
		boolean ok = false;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals(ciudad1));
				ok = true;
		}
		if (ok) {
			caminoSinCargarCombustible(v.getPosicion(),camino,marca,ciudad2,lis,tanqueAuto);
		}
		return camino;
	}
	private boolean caminoSinCargarCombustible(int i, ListaGenerica<String> camino, boolean[]marca, String destino,ListaGenerica<String> lis, int tanqueAuto) {
		marca[i] = true;
		boolean ok  = false;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		lis.agregarFinal(v.dato());
		if (v.dato().equals(destino) && tanqueAuto >= 0 && !ok) {
			clonar(camino,lis);
			return true;
		}else{
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !ok && tanqueAuto >= 0) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && !ok) {
					tanqueAuto -= arista.peso();
					if(tanqueAuto >= 0) {
						ok = caminoSinCargarCombustible(j,camino,marca,destino,lis,tanqueAuto);
						lis.eliminarEn(lis.tamanio());
					}
					marca[j] = false;
					tanqueAuto += arista.peso();
				}
			}
		}
		return ok;
	}
	public ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		
		Vertice<String> v = null;
		boolean ok = false;
		aux.comenzar();
		while(!aux.fin() && !ok) {
			v = aux.proximo();
			if (v.dato().equals(ciudad1));
				ok = true;
		}
		if (ok) {
			int cant = 0;
			int carga = tanqueAuto;
			Min min = new Min(Integer.MAX_VALUE);
			caminoConMenorCargaDeCombustible(v.getPosicion(),camino,marca,ciudad2,lis,tanqueAuto,cant,min,carga);
		}
		return camino;
	}
	private void caminoConMenorCargaDeCombustible(int i, ListaGenerica<String> camino, boolean[]marca, String destino,ListaGenerica<String> lis, int tanqueAuto, int cant, Min min,int carga) {
		marca[i] = true;
		int t = tanqueAuto;
		boolean c = false;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		lis.agregarFinal(v.dato());
		if (v.dato().equals(destino) && tanqueAuto >= 0 && cant < min.getMinimo()) {
			System.out.println(cant);
			clonar2(lis,camino);
			min.setMinimo(cant);
		}else{
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && tanqueAuto >= 0) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					if(carga >= arista.peso()) {
						tanqueAuto -= arista.peso();
						if(tanqueAuto < 0) {
							tanqueAuto = carga;
							cant++;
							c = true;
						}
						caminoConMenorCargaDeCombustible(j,camino,marca,destino,lis,tanqueAuto,cant,min,carga);
						lis.eliminarEn(lis.tamanio());
						if(c) {
							cant--;
						}
						tanqueAuto = t;
					}
					marca[j] = false;
				
				}
			}
		}
	}
	public ListaGenerica<String> caminoConMenorCargaDeCombustible2(String ciudad1, String ciudad2, int tanqueAuto){
		Min minimo = new Min (9999);
		boolean[]marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (tanqueAuto != 0) {
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			boolean ok = false;
			int i = -1;
			while ((!aux.fin()) && (!ok)) {
				vertice = aux.proximo();
				if (vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if (i != -1) {
				int carga = tanqueAuto;
				int cant = 0;
				dfsMenorCarga (i,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
			}
		}
		return camino;
		
	}
	
	private void dfsMenorCarga (int i,ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino,boolean[]marca,String ciudad2,int tanqueAuto, int carga, int cant,Min minimo) {
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			if (cant < minimo.getMinimo()) { //SI ES EL MINIMO DE CARGAS CLONO EL CAMINO Y AHORA PASA A SER EL MINIMO
				System.out.println(cant);
				clonar2 (lis,camino);
				minimo.setMinimo(cant);
			}
		}
		else {
			if (tanqueAuto == 0) { //SI LLEGO A CIUDAD Y ME QUEDE SIN COMBUSTIBLE CARGO
				tanqueAuto+= carga - tanqueAuto;
				cant++; //INCREMENTO CONTADOR DE CARGAS
			}
			marca[i] = true;
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					tanqueAuto-= arista.peso(); //RESTO LO QUE VOY A GASTAR DE COMBUSTIBLE
					if (tanqueAuto >= 0) { //VERIFICO QUE NO ME VOY A QUEDAR SIN COMBUSTIBLE EN EL MEDIO DE LA RUTA
						lis.agregarFinal(arista.verticeDestino().dato());
						dfsMenorCarga(j,lis,camino,marca,ciudad2,tanqueAuto,carga,cant,minimo);
						lis.eliminarEn(lis.tamanio());
					}
					tanqueAuto+=arista.peso(); //SUMO LO QUE LE RESTE PARA PODER CAMBIAR DE CAMINO Y SEGUIR CON LA SUMA
				}
			}
		}
	}
	private void clonar(ListaGenerica<String> c,ListaGenerica<String> l) {
		l.comenzar();
		while(!l.fin()) {
			c.agregarFinal(l.proximo());
		}
	}
	private void clonar2 (ListaGenerica<String> lis,ListaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
}
