package generadores;

import grafo.GrafoNDNP;
import java.io.*;
import java.util.Random;

public class GeneradorRegAdy {
	private GrafoNDNP g;
	private int orden;
	
	public GeneradorRegAdy(int nodos, double porc) throws GrafoImposibleException{
		int grado = (int) Math.floor((nodos-1)*porc/2);
		if (grado >= nodos)
			throw new GrafoImposibleException("No se puede realizar este grafo");
		g = new GrafoNDNP(nodos);
		orden = g.getCantNodos();
		for(int i = 0; i < nodos; i++) {
			int aristasRest = grado;
			for(int j = 0; j < i; j++)
				aristasRest -= g.getArista(i, j)? 1: 0;
			int test = this.randomBetween(i + 1, orden), repeat = 0;
			while(aristasRest > 0 && repeat < 100) {
				if(!g.getArista(i, test)) {
					g.setArista(i, test);
					aristasRest--;
				}
				test = randomBetween(i + 1, orden);
				repeat++;
			}
			if (repeat > 100)
				throw new GrafoImposibleException("No se puede realizar este grafo");
		}
	}

	private int randomBetween(int a, int b) {
		Random rnd = new Random();
		return rnd.nextInt() % (b - a) + a;
	}

	public void imprimir() {
		FileWriter fw;
		PrintWriter pw = null;
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
