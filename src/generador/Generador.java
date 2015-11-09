package generador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import grafo.GrafoNDNP;

public class Generador {
	
	public static void aleatorioPorcAdy(GrafoNDNP g, int cantNodos, double porcAdy){
		
		int cantAdy = (int) (cantNodos*porcAdy/100),
				maxAristas;
		Random r = new Random();
		g = new GrafoNDNP(cantNodos);
		maxAristas = g.getMaxAristas();
		int arista= r.nextInt(maxAristas);
		while(cantAdy>0){
			int [] indices = g.getIndices(arista);
			if(!g.getAdyacencia(indices[0], indices[1])){
				g.setAdyacencia(indices[0], indices[1]);
				cantAdy--;
			}
			arista = r.nextInt(maxAristas);
		}
	}

	public static void aleatorioProbAristas( GrafoNDNP g, int nodos, double prob) {
		Random r = new Random();
		double p;
		g = new GrafoNDNP(nodos);
		for(int i = 0; i < nodos; i++) {
			for(int j = i + 1; j < nodos; j++){
				p = r.nextDouble();
				if(p < prob)
					g.setAdyacencia(i, j);
			}
		}
	}
	
	public static void regularPorcAdy(GrafoNDNP g, int nodos, double porc){
		int grado = (int)Math.floor((nodos-1)*porc/2),
			orden = g.getCantNodos(),
			cantArist,
			rand,
			rep;
		Random r = new Random();
		if (grado >= nodos)
			System.out.println("No se puede generar el grafo regular con el porcentaje:" + porc);
		g = new GrafoNDNP(nodos);
		orden = g.getCantNodos();
		for(int i = 0; i < nodos; i++) {
			cantArist = grado;
			for(int j = 0; j < i; j++)
				if(g.getAdyacencia(i, j))
					cantArist --;
			rand = r.nextInt(orden)-r.nextInt(i+1);
			rep = 0;
			while(cantArist > 0 && rep < 100) {
				if(!g.getAdyacencia(i, rand)) {
					g.setAdyacencia(i, rand);
					cantArist--;
				}
				rand = r.nextInt(orden)-r.nextInt(i+1);
				rep++;
			}
			if (rep > 100)
				System.out.println("Hay mas de 100 repeticiones");
		}
	}

	public static void regularGrado(GrafoNDNP g, int nodos, int grado){
		int cantAristas,
			rand,
			rep,
			orden = nodos;
		Random r = new Random();
	
		if (grado >= nodos)
			System.out.println("No se puede realizar el grafo con grado: " + grado);
		g = new GrafoNDNP(nodos);
		orden = g.getCantNodos();
		for(int i = 0; i < nodos; i++) {
			cantAristas = grado;
			for(int j = 0; j < i; j++)
				if(g.getAdyacencia(i, j))
				cantAristas --;
			rand = r.nextInt((orden - i+1) + 1) + i+1;
			rep = 0;
			while(cantAristas > 0 && rep < 100) {
				if(!g.getAdyacencia(i, rand)) {
					g.setAdyacencia(i, rand);
					cantAristas--;
				}
				rand = r.nextInt((orden - i+1) + 1) + i+1;
				rep++;
			}
			if (rep > 100)
				System.out.println("Hay mas de 100 repeticiones");
		}
	}
	
	public static void partito(GrafoNDNP g, int nodos, int part){
		if (part >= nodos)
			System.out.println("No se puede generar el grafo con "+ nodos +" nodos y " + part + " partes.");
		g = new GrafoNDNP(nodos);
		for(int i = 0; i < nodos; i++)
			for(int j = (i / part) * part + part; j < nodos; j++)
				g.setAdyacencia(i, j);
	}
	
	
	
}
