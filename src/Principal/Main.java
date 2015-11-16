package Principal;

import generador.Generador;
import grafo.GrafoNDNP;

public class Main {
	public static void main(String[] args) {
		
		GrafoNDNP g1= Generador.aleatorioPorcAdy(600, 40);
		GrafoNDNP g2= Generador.aleatorioPorcAdy(600, 60);
		GrafoNDNP g3= Generador.aleatorioPorcAdy(600, 90);
		
		GrafoNDNP g4 = Generador.regularPorcAdy(1000, 50);
		GrafoNDNP g5 = Generador.regularPorcAdy(1000, 75);
		
		
			}
}
