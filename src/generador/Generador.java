package generador;

import java.util.Random;

import grafo.GrafoNDNP;

public class Generador {
	
	public static GrafoNDNP aleatorioPorcAdy(int cantNodos, double porcAdy){
		
		
		Random r = new Random();
		GrafoNDNP g = new GrafoNDNP(cantNodos);
		int cantAdy = (int) (g.getMaxAristas()*porcAdy/100),
				maxAristas;
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
		return g;
	}

	public static GrafoNDNP aleatorioProbAristas(int nodos, double prob) {
		Random r = new Random();
		double p;
		GrafoNDNP g = new GrafoNDNP(nodos);
		
		for(int i = 0; i < nodos; i++) {
			for(int j = i + 1; j < nodos; j++){
				p = r.nextDouble();
				if(p <= prob)
					g.setAdyacencia(i, j);
			}
		}
		
		return g;
	}
	
	public static GrafoNDNP regularPorcAdy(int nodos, double porc){
		int grado = (int) Math.floor((nodos)*porc/100);
		
		return regularGrado(nodos, grado);
	}

	public static GrafoNDNP regularGrado(int nodos, int grado){
		
		GrafoNDNP g = new GrafoNDNP(nodos);
		
		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<0){
			System.out.println("No se puede realizar el grafo con grado: " + grado);
			return g;
		}
		if((grado==1))
			genGrado1(g, nodos);
		
		if(grado>=2){
			
			if(grado>2){
				
				if(nodos%grado == 0 && grado >3)
					genGradoMultiplo(g, nodos, grado);
				else
					genGradoMayor2(g, nodos, grado);
			}
			else
				genGrado2(g, nodos);
		}


		if(!g.todosMismoGrado(grado)){
			System.out.println("No se puede generar un grafo regular");
			g = new GrafoNDNP(nodos);
		}
		return g;
	}
	
	private static void genGrado1(GrafoNDNP g, int nodos){
		int i=0;
		while(i<nodos){
			g.setAdyacencia(i, i+1);
			i+=2;
		}
	}
	
	private static void genGrado2(GrafoNDNP g, int nodos){
		int i=0;
		g.setAdyacencia(i, nodos-1);
		while(i<nodos-1){
			g.setAdyacencia(i, i+1);
			i++;
		}
	}
	
	private static void genGradoMayor2(GrafoNDNP g, int nodos, int grado){
		int i=0, j, vueltas;
		genGrado2(g, nodos);
		while(i<nodos){
			j=i+grado;
			vueltas =0;
			while(g.getGrado(i)<grado && vueltas <nodos){
				if(j>nodos-1)
					j-=nodos;
				if(g.getGrado(j)<grado && i != j && !g.getAdyacencia(i, j))
					g.setAdyacencia(i, j);
				j+=grado;
				vueltas++;
				
			}
			i++;
		}
		
	}
	
	private static void genGradoMultiplo(GrafoNDNP g, int nodos, int grado){
		genGrado1(g, nodos);
		genGradoMayor2(g, nodos, grado-1);
	}
	
	public static void partito(GrafoNDNP g, int nodos, int part){
		if (part >= nodos)
			System.out.println("No se puede generar el grafo con "+ nodos +" nodos y " + part + " partes.");
		
		for(int i = 0; i < nodos; i++)
			for(int j = (i / part) * part + part; j < nodos; j++)
				g.setAdyacencia(i, j);
	}
	
	
	
}
