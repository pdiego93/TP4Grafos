package archivo;

import java.io.FileWriter;
import java.io.PrintWriter;

import grafo.GrafoNDNP;

public class Archivo {
	public void imprimir(GrafoNDNP g) {
		FileWriter fw;
		PrintWriter pw = null;
		int orden = g.getCantNodos(), 
			cantAristas = g.cantidadAristas(), 
			gradoMin = g.getGrado(0), 
			gradoMax = g.getGrado(0),
			aux;
		
		double porc = (g.cantidadAristas()/g.getMaxAristas())*100;
		
		for(int i = 1; i < orden; i++) {
			aux = g.getGrado(i);
			if(aux < gradoMin)
				gradoMin = aux;
			if(aux > gradoMax)
				gradoMax = aux;
		}
		try {
			fw = new FileWriter("Entradas//grafo.in");
			pw = new PrintWriter(fw);
			pw.println(orden + " " + cantAristas + " " + porc + " " + gradoMax + " " + gradoMin);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (g.getAdyacencia(i, j))
						pw.println(i + " " + j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
