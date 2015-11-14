package generador;
import grafo.*;

public class MainGenerador {

	public static void main(String[] args) {
		
		GrafoNDNP g = Generador.regularGrado(8, 4);
		for(int i =0;i<g.getMaxAristas();i++)
			System.out.println(g.getIndices(i)[0] + " " + g.getIndices(i)[1] + " " + g.getAdyacencia(g.getIndices(i)[0],g.getIndices(i)[1]));
		
	}

}

