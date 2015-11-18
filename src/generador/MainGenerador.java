package generador;

import archivo.Archivo;
import grafo.*;
import principal.Main;

public class MainGenerador {

	public static void main(String[] args) {

		GrafoNDNP g /* = Generador.regularGrado(8, 4) */;
		// Archivo.escribirGrafo(g, "Entradas//grafo.in");
		g = Generador.aleatorioPorcAdy(10, 90);
	
		int cont = 0,
				cant= 100;
		int [] cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 40. Primer mejor corrida nro: " + (Main.getMenor(cantCol)+1) + ", colores: " + cantCol[Main.getMenor(cantCol)]);
		Archivo.escribirInformeDeColores(g, 90, cant, 0); 
		g.reiniciarColoresTot();
		
		if(g==null)
			return;
	}

}
