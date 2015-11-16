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

		for(int i = 0; i < out.getCantNodos(); i++) {
			int colori = out.getColor(i);
			for(int j = i+1; j <  ; j++){
				
			}
		}
		
	}

}
