package generadores;

import grafo.GrafoNDNP;

import java.io.*;
import java.util.Random;

public class GeneradorNyPorcAdy {
	private GrafoNDNP g;
	private int orden;
	
	public GeneradorNyPorcAdy(int nodos, double ady) throws GrafoImposibleException{
		if (ady > 100 || ady < 0) throw new GrafoImposibleException("No se puede realizar este grafo");
		g = new GrafoNDNP(nodos);
		int limite = g.getMaxAristas(), aristasRest = (int) Math.floor(limite * ady);
		int test = this.randomBetween(0, limite);
		while(aristasRest > 0) {
			if(!g.getArista(g.getFila(test), g.getColumna(test))) {
				g.setArista(g.getFila(test), g.getColumna(test));
				aristasRest--;
			}
			test = randomBetween(0, limite);
		}
	}

	private int randomBetween(int a, int b) {
		Random rnd = new Random();
		return rnd.nextInt() % (b - a) + a;
	}

	public void imprimir() {
		FileWriter fw;
		PrintWriter pw = null;
		orden = g.getCantNodos();
		int aristas = g.cantidadAristas(), minG = g.getGrado(0), maxG = g.getGrado(0);
		double perc = g.cantidadAristas()/g.getMaxAristas();
		for(int i = 1; i < orden; i++) {
			int aux = g.getGrado(i);
			if(aux < minG)
				minG = aux;
			if(aux > maxG)
				maxG = aux;
		}
		try {
			fw = new FileWriter("grafo.in");
			pw = new PrintWriter(fw);
			pw.println(orden + " " + aristas + " " + perc + " " + maxG + " " + minG);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (g.getArista(i, j))
						pw.println(i + " " + j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}