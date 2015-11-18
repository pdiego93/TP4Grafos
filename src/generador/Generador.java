package generador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import grafo.GrafoNDNP;

public class Generador {
	
	public static GrafoNDNP aleatorioPorcAdy(int cantNodos, double porcAdy){
		Random r = new Random();
		GrafoNDNP g = new GrafoNDNP(cantNodos);
		int cantAdy = (int)Math.round(cantNodos*(cantNodos-1)/2*porcAdy/100),
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
		int ca = (int) Math.round((porc/100)*(nodos*(nodos-1)/2)),
			grado = (int) Math.round(((porc/100)*(nodos*(nodos-1)/2))*2/nodos); 
		return regularGrado(nodos, grado);
	}

	public static GrafoNDNP regularGrado(int nodos, int grado){
		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<0){
			System.out.println("No se puede realizar el grafo con grado: " + grado);
			//System.out.println("1");
			return null;
		}		
		
		int[][] aristas = new int[(nodos*grado) / 2][2];
		int[] v = new int[nodos];
		for(int i = 0; i < nodos; i++){
			v[i] = i;
		}
        int t = 0;
        if(grado%2 == 0) {
            for (int i = 0; i < nodos; i++) {
                for (int j = i + 1; j < i+(grado / 2) + 1; j++) {
                    if(i != j) {
                        aristas[t++] = new int[]{v[i], v[j % nodos]};
                    }
                }
            }
        } else {
            for (int i = 0; i < nodos; i++) {
                for (int j = i + 1; j < i + ((grado - 1) / 2) + 1; j++) {
                    int[] e = new int[]{v[i], v[j % nodos]};
                    aristas[t++] = e;
                }

               /* for (int j = i - 1; j > i - ((grado - 1) / 2) - 1; j--) {
                    int[] e = new int[]{v[i], v[(j + nodos) % nodos]};
                    System.out.println("f2: " + i + " " + ((j % nodos)%nodos));
                    aristas[t++] = e;
                }*/
            }

            for (int i = 0; i < nodos/2; i++) {
                aristas[t++] = new int[]{v[i], v[(i+(nodos/2))%nodos]};
            }
        }
        GrafoNDNP g = new GrafoNDNP(nodos);
        for(int i = 0; i < aristas.length; i++){
        	g.setAdyacencia(aristas[i][0], aristas[i][1]);
        }
        if(!g.todosMismoGrado(grado)){
			System.out.println("No se puede generar un grafo regular");
			g = null;
        }	
		
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
