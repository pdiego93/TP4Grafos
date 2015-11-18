package principal;

import archivo.Archivo;
import generador.Generador;
import grafo.GrafoNDNP;

public class Main {
	public static void main(String[] args) {
		
		GrafoNDNP g ;
		
		
		int cant=10000;
		g= Generador.aleatorioPorcAdy(600, 40);
		int cont = 0;
		int [] cantColSec = new int [cant];
		int [] cantColWP = new int [cant];
		int [] cantColMat = new int [cant];
 		while(cont <cant){
			g.secuencial();
			cantColSec[cont]=g.getCantColores();
			g.welshPowell();
			cantColWP[cont]=g.getCantColores();
			g.matula();
			cantColMat[cont]=g.getCantColores();
			
			if(cont%500==0)
				System.out.println(cont);
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 40. Primer mejor corrida nro: " + (getMenor(cantColSec)+1) + " colores: " + cantColSec[getMenor(cantColSec)]);
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 40.  Primer mejor corrida nro: "+ (getMenor(cantColWP)+1) + " colores: " + cantColWP[getMenor(cantColWP)]);
		System.out.println("Coloreo Matula. Aleatorio. Porc. Ady: 40. Primer mejor corrida nro: " + (getMenor(cantColMat)+1) + " colores: " + cantColMat[getMenor(cantColMat)]);
		Archivo.escribirInformeDeColores(g, 40, cant, 0); 
		
		g.reiniciarColoresTot();
		
		cont =0;
		cantColSec = new int [cant];
		cantColWP = new int [cant];
		cantColMat = new int [cant];
		g= Generador.aleatorioPorcAdy(600, 60);
		while(cont <cant){
			g.secuencial();
			cantColSec[cont]=g.getCantColores();
			g.welshPowell();
			cantColWP[cont]=g.getCantColores();
			g.matula();
			cantColMat[cont]=g.getCantColores();
			if(cont%500==0)
				System.out.println(cont);
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 60. Primer mejor corrida nro: " + getMenor(cantColSec) + " colores: " + cantColSec[getMenor(cantColSec)]);
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 60.  Primer mejor corrida nro: "+ getMenor(cantColWP) + " colores: " + cantColWP[getMenor(cantColWP)]);
		System.out.println("Coloreo Matula. Aleatorio. Porc. Ady: 60. Primer mejor corrida nro: " + getMenor(cantColMat) + " colores: " + cantColMat[getMenor(cantColMat)]);
		Archivo.escribirInformeDeColores(g, 60, cant, 0); 
		
		g.reiniciarColoresTot();
		
		cont =0;
		cantColSec = new int [cant];
		cantColWP = new int [cant];
		cantColMat = new int [cant];
		g= Generador.aleatorioPorcAdy(600, 90);
		while(cont <cant){
			g.secuencial();
			cantColSec[cont]=g.getCantColores();
			g.welshPowell();
			cantColWP[cont]=g.getCantColores();
			g.matula();
			cantColMat[cont]=g.getCantColores();
			if(cont%500==0)
				System.out.println(cont);
			cont++;
		}
		System.out.println("Coloreo secuencial. Aleatorio. Porc. Ady: 90. Primer mejor corrida nro: " + getMenor(cantColSec) + " colores: " + cantColSec[getMenor(cantColSec)]);
		System.out.println("Welsh-Powell. Aleatorio. Porc. Ady: 90.  Primer mejor corrida nro: "+ getMenor(cantColWP) + " colores: " + cantColWP[getMenor(cantColWP)]);
		System.out.println("Coloreo Matula. Aleatorio. Porc. Ady: 90. Primer mejor corrida nro: " + getMenor(cantColMat) + " colores: " + cantColMat[getMenor(cantColMat)]);
		Archivo.escribirInformeDeColores(g, 90, cant, 0); 
		
		g.reiniciarColoresTot();
		
		
		cont =0;
		cantColSec = new int [cant];
		cantColWP = new int [cant];
		cantColMat = new int [cant];
		g= Generador.regularPorcAdy(1000, 50);
		while(cont <cant){
			g.secuencial();
			cantColSec[cont]=g.getCantColores();
			g.welshPowell();
			cantColWP[cont]=g.getCantColores();
			g.matula();
			cantColMat[cont]=g.getCantColores();
			if(cont%500==0)
				System.out.println(cont);
			cont++;
		}
		System.out.println("Coloreo secuencial. Regular. Porc. Ady: 50. Primer mejor corrida nro: " + getMenor(cantColSec) + " colores: " + cantColSec[getMenor(cantColSec)]);
		System.out.println("Welsh-Powell. Regular. Porc. Ady: 50.  Primer mejor corrida nro: "+ getMenor(cantColWP) + " colores: " + cantColWP[getMenor(cantColWP)]);
		System.out.println("Coloreo Matula. Regular. Porc. Ady: 50. Primer mejor corrida nro: " + getMenor(cantColMat) + " colores: " + cantColMat[getMenor(cantColMat)]);
		Archivo.escribirInformeDeColores(g, 50, cant, 1); 
		
		g.reiniciarColoresTot();
		
		cont =0;
		cantColSec = new int [cant];
		cantColWP = new int [cant];
		cantColMat = new int [cant];
		g= Generador.regularPorcAdy(1000, 75);
		while(cont <cant){
			g.secuencial();
			cantColSec[cont]=g.getCantColores();
			g.welshPowell();
			cantColWP[cont]=g.getCantColores();
			g.matula();
			cantColMat[cont]=g.getCantColores();
			if(cont%500==0)
				System.out.println(cont);
			cont++;
		}
		System.out.println("Coloreo secuencial. Regular. Porc. Ady: 75. Primer mejor corrida nro: " + getMenor(cantColSec) + " colores: " + cantColSec[getMenor(cantColSec)]);
		System.out.println("Welsh-Powell. Regular. Porc. Ady: 75.  Primer mejor corrida nro: "+ getMenor(cantColWP) + " colores: " + cantColWP[getMenor(cantColWP)]);
		System.out.println("Coloreo Matula. Regular. Porc. Ady: 75. Primer mejor corrida nro: " + getMenor(cantColMat) + " colores: " + cantColMat[getMenor(cantColMat)]);
		Archivo.escribirInformeDeColores(g, 75, cant, 1); 
		
		g.reiniciarColoresTot();
		
	}
	
	public static int getMenor(int [] v){
		int pos=0, i=0;
		while(i<v.length){
			if(v[i]<v[pos])
				pos=i;
				
			i++;
		}
		return pos;
	}
}
