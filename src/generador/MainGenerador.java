package generador;

import grafo.*;

public class MainGenerador {

	public static void main(String[] args) {

		GrafoNDNP g /* = Generador.regularGrado(8, 4) */;
		// Archivo.escribirGrafo(g, "Entradas//grafo.in");

//		g = Generador.regularPorcAdy(1000, 80);
		g = Generador.regularPorcAdy(1000, 75);
		/*for(int i=0;i<g.getCantNodos();i++)
			for(int j=0; j<g.getCantNodos();j++)
				if(i!=j)
					System.out.println(i + " " + j + " " + g.getAdyacencia(i, j));
		*/
		if(g==null)
			return;
//		int f = 0;
//		int[] colors = new int[10];
//		while (f < 10) {
//			g.secuencial();
//			System.out.println(g.getCantColores());
//			colors[f] = g.getCantColores();
//			f++;
//		}
//		g.informeDeColores(colors);

		/*
		 * for(int i =0;i<g.getMaxAristas();i++)
		 * System.out.println(g.getIndices(i)[0] + " " + g.getIndices(i)[1] +
		 * " " + g.getAdyacencia(g.getIndices(i)[0],g.getIndices(i)[1]));
		 */
	}

}
