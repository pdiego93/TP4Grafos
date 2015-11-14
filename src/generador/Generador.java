package generador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import grafo.GrafoNDNP;

public class Generador {
	
	public static void aleatorioPorcAdy(GrafoNDNP g, int cantNodos, double porcAdy){
		
		int cantAdy = (int) (g.getMaxAristas()*porcAdy/100),
				maxAristas;
		Random r = new Random();
		System.out.println(cantAdy);
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
		
		for(int i = 0; i < nodos; i++) {
			for(int j = i + 1; j < nodos; j++){
				p = r.nextDouble();
				if(p <= prob)
					g.setAdyacencia(i, j);
			}
		}
	}
	
	public static GrafoNDNP regularPorcAdy(int nodos, double porc){
		int grado = (int) Math.floor((nodos)*porc/100);
		
		return regularGrado(nodos, grado);
	}

	public static GrafoNDNP regularGrado(int nodos, int grado){
		int i=0,j, vueltas;
		GrafoNDNP g = new GrafoNDNP(nodos);
		
		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<1){
			System.out.println("No se puede realizar el grafo con grado: " + grado);
			return g;
		}
		
		if((grado==1))
			while(i<nodos){
				g.setAdyacencia(i, i+1);
				i+=2;
			}
		i=0;
		
		if(grado>=2){
			g.setAdyacencia(i, nodos-1);
			while(i<nodos-1){
				g.setAdyacencia(i, i+1);
				i++;
			}
			
		i=0;
		if(grado>2)
			while(i<nodos){
				j=i+grado;
				vueltas =0;
				while(g.getGrado(i)<grado && vueltas <nodos){
					if(j>nodos-1)
						j-=nodos;
					if(g.getGrado(j)<grado && i != j)
						g.setAdyacencia(i, j);
					System.out.println("g: "+grado);
					j+=grado;
					vueltas++;
				}
			i++;
			}
		
			
		}
		
		if(!g.todosMismoGrado(grado))
			System.out.println("No se puede generar un grafo regular");
		g = new GrafoNDNP(nodos);
		return g;
	}
	
	public static void partito(GrafoNDNP g, int nodos, int part){
		if (part >= nodos)
			System.out.println("No se puede generar el grafo con "+ nodos +" nodos y " + part + " partes.");
		
		for(int i = 0; i < nodos; i++)
			for(int j = (i / part) * part + part; j < nodos; j++)
				g.setAdyacencia(i, j);
	}
	
	
	
}
