package generadores;

import grafo.GrafoNDNP;

import java.io.*;

public class GeneradorNyProb {
	private GrafoNDNP g;
	private int orden;
	
	public GeneradorNyProb(int nodos, double prob) {
		g = new GrafoNDNP(nodos);
		for(int i = 0; i < nodos; i++) {
			for(int j = i + 1; j < nodos; j++)
				if(Math.random() < prob)
					g.setArista(i, j);
		}
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
