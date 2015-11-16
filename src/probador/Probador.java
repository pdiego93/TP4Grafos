package probador;

import archivo.Archivo;
import grafo.GrafoNDNP;

public class Probador {

	public static void main(String[] args) {
		GrafoNDNP in;
		GrafoNDNP out;

		String rutaIn = "grafo.in";
		String rutaOut = "coloreado.out";

		in = Archivo.leerGrafo(rutaIn);
		out = Archivo.leerGrafoColoreado(rutaOut);

		System.out.println(
				test(in, out) ? 
				"Se coloreo de manera correcta."
				: "Error en el coloreo.");

	}

	private static boolean test(GrafoNDNP in, GrafoNDNP out) {
		
		for (int i = 0; i < out.getCantNodos(); i++) {
			int colori = out.getColor(i);
			if(colori == 0)
				return false;
			
			for (int j = i + 1; j < out.getCantNodos(); j++)
				if (in.getAdyacencia(i, j) && colori == out.getColor(j))
					return false;
		}
		return true;
	}
}
