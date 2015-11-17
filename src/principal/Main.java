package principal;



import java.awt.geom.RectangularShape;

import archivo.Archivo;
import generador.Generador;
import grafo.GrafoNDNP;

public class Main {
	public static void main(String[] args) {
		
		GrafoNDNP g ;
		
		
		int cant=100;
		g= Generador.aleatorioPorcAdy(600, 40);
		int cont = 0;
		int [] cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			//System.out.println(g.getCantColores());
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 40. Primer mejor corrida nro: " + getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		g.informeDeColores(cantCol);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.welshPowell();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 40.  Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.matula();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Matula. Aleatorio. Porc. Ady: 40. Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		/*****************************/
		
		g= Generador.aleatorioPorcAdy(600, 60);
		
		cont = 0;
		cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 60. Primer mejor corrida nro: " + getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.welshPowell();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 60.  Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.matula();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Matula. Aleatorio. Porc. Ady: 60. Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		/*****************************/
		
		g= Generador.aleatorioPorcAdy(600, 90);
		
		cont = 0;
		cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 90. Primer mejor corrida nro: " + getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.welshPowell();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 90.  Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.matula();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Matula. Aleatorio. Porc. Ady: 90. Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		
		/*************************/
		
		g = Generador.regularPorcAdy(1000, 50);
		
		cont = 0;
		cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Regular. Porc. Ady: 50. Primer mejor corrida nro: " + getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.welshPowell();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Welsh-Powell. Regular. Porc. Ady: 50.  Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.matula();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Matula. Regular. Porc. Ady: 50. Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		
		/******************************/
		
		g = Generador.regularPorcAdy(1000, 75);
		
		cont = 0;
		cantCol = new int [cant];
		while(cont <cant){
			g.secuencial();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Coloreo secuencial. Regular. Porc. Ady: 75. Primer mejor corrida nro: " + getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.welshPowell();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Welsh-Powell. Regular. Porc. Ady: 75.  Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
		cont =0;
		cantCol = new int [cant];
		while(cont <cant){
			g.matula();
			cantCol[cont]=g.getCantColores();
			cont++;
		}
		System.out.println("Matula. Porc. Regular. Ady: 75. Primer mejor corrida nro: "+ getMenor(cantCol) + " colores: " + cantCol[getMenor(cantCol)]);
		
	}
	
	public static int getMenor(int []v){
		int pos=0, i=0;
		while(i<v.length-1){
			if(v[i]<v[i+1])
				pos=i;
				
			i++;
		}
		return pos+1;
	}
	
}
