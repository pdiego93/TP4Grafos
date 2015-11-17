package generador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import grafo.GrafoNDNP;

public class Generador {
	
	public static GrafoNDNP aleatorioPorcAdy(int cantNodos, double porcAdy){
		Random r = new Random();
		GrafoNDNP g = new GrafoNDNP(cantNodos);
		int cantAdy = (int) ((cantNodos-1)*porcAdy/100),
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
		int grado = (int) Math.floor((nodos-1)*porc/100);
		
		return regularGrado(nodos, grado);
	}

//	public static GrafoNDNP regularGrado(int nodos, int grado){
//		
//		GrafoNDNP g = new GrafoNDNP(nodos);
//		
//		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<0){
//			System.out.println("No se puede realizar el grafo con grado: " + grado);
//			return g;
//		}
//		if((grado==1))
//			genGrado1(g, nodos);
//		
//		if(grado>=2){
//			
//			if(grado>2){
//				
//				if(nodos%grado == 0 && grado >3)
//					genGradoMultiplo(g, nodos, grado);
//				else{
//					genGrado2(g, nodos);
//					genConSalto(g, nodos, grado, grado);
//				
//				}
//			}
//			else
//				genGrado2(g, nodos);
//		}
//		
//		if(!g.todosMismoGrado(grado)){
//			System.out.println("No se puede generar un grafo regular");
//			g = new GrafoNDNP(nodos);
//		}
//		return g;
//	}

	
//	public static GrafoNDNP regularGrado(int nodos, int grado){
//		
//		GrafoNDNP g = null;
//		
//		
//		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<0){
//			System.out.println("No se puede realizar el grafo con grado: " + grado);
//			System.out.println("1");
//			return g;
//		}
//		
//		ArrayList<Integer> vertices = new ArrayList<Integer>(nodos*grado);
//		
//		for(int i = 0; i < nodos; i++){
//			for(int j = 0; j < grado; j++){
//				vertices.add(i);
//			}
//		}
//		
//		boolean incorrecto = true;
//		while(incorrecto){
//			g = new GrafoNDNP(nodos);
//			Collections.shuffle(vertices);
//			incorrecto = false;
//			
//			for(int i = 0; i < (nodos*grado/2); i++){
//				System.out.println(vertices.get(2*i)+" - "+vertices.get(2*i+1));
//				if(vertices.get(2*i)==vertices.get(2*i+1)||g.getAdyacencia(vertices.get(2*i), vertices.get(2*i+1))){
//					System.out.println("incorrecto");
//					incorrecto = true;
//				}else{
//					g.setAdyacencia(vertices.get(2*i), vertices.get(2*i+1));
//				}
//			}
//			
//		}
//		
//		
//		if(!g.todosMismoGrado(grado)){
//			System.out.println("No se puede generar un grafo regular");
//			System.out.println("2");
//			g = null;
//		}
//		return g;
//	}

	public static GrafoNDNP regularGrado(int nodos, int grado){
		if (grado >= nodos || (nodos%2==1 && grado%2==1) || grado<0){
			System.out.println("No se puede realizar el grafo con grado: " + grado);
			System.out.println("1");
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
            for (int i = 0; i < nodos; i=i+2) {
                for (int j = i + 1; j < i + ((grado - 1) / 2) + 1; j++) {
                    int[] e = new int[]{v[i], v[j % nodos]};
                    aristas[t++] = e;
                }

                for (int j = i - 1; j > i - ((grado - 1) / 2) - 1; j--) {
                    int[] e = new int[]{v[i], v[(j + nodos) % nodos]};
                    aristas[t++] = e;
                }
            }

            for (int i = 0; i < nodos/2; i++) {
                aristas[t++] = new int[]{v[i], v[(i+(nodos/2))%nodos]};
            }
        }
        GrafoNDNP g = new GrafoNDNP(nodos);
        for(int i = 0; i < aristas.length; i++){
        	System.out.println(aristas[i][0]+" "+aristas[i][1]);
        	g.setAdyacencia(aristas[i][0], aristas[i][1]);
        }
        if(!g.todosMismoGrado(grado)){
			System.out.println("No se puede generar un grafo regular");
			System.out.println("2");
			g = null;
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
	
	/*private static void genGradoMayor3(GrafoNDNP g, int nodos, int grado){
		int i=0, j, vueltas;
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
		
	}*/
	
	private static void genConSalto(GrafoNDNP g, int nodos, int grado, int salto){
		int i=0, j, vueltas;
		while(i<nodos){
			j=i+salto;
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
		genConSalto(g, nodos, grado, grado-1);
		genGrado1(g, nodos);
	}
	
	public static void partito(GrafoNDNP g, int nodos, int part){
		if (part >= nodos)
			System.out.println("No se puede generar el grafo con "+ nodos +" nodos y " + part + " partes.");
		
		for(int i = 0; i < nodos; i++)
			for(int j = (i / part) * part + part; j < nodos; j++)
				g.setAdyacencia(i, j);
	}
	
	
	
}
