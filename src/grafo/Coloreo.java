package grafo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Coloreo {
	private int [][] elementos;
	
	public Coloreo(GrafoNDNP g){
		elementos = new int [g.getOrden()][2];
		for(int i = 0; i<elementos.length;i++){
			elementos[i][0]=i;
			elementos[i][1]=g.getGrado(i);
		}
	}
	
	public static void secuencial(GrafoNDNP g){
		mezclar(elementos);
		colorear(g);
	}
	
	public void welshPowell(GrafoNDNP g){
		Arrays.sort(elementos);
		colorear(g);
	}
	
	public void matula(GrafoNDNP g){
		ordenMayorAMenor(elementos);
		colorear(g);
	}
	
	private static void colorear(GrafoNDNP g){
		int [] colores = new int [g.getCantNodos()];
		
		
	}
	
	private static void mezclar(int [][] v){
		Random rnd = new Random();
		int aux;
	    for (int i = 0; i < v.length; i++)
	    {
	      int index = rnd.nextInt(i + 1);
	      
	      aux = v[index][0];
	      v[index][0] = v[i][0];
	      v[i][0] = aux;
	      aux = v[index][1];
	      v[index][1] = v[i][1];
	      v[i][1] = aux;
	    }
	}
	
	private static void ordenMayorAMenor(int [][] v){
		int i=0, f=1, aux;
		while(i<v.length && f==1){
			f=0;
			for(int j=0; j<v.length-1; j++){
				if(v[i][1]<v[j][1]){
					f=1;
					aux = v[j][0];
				      v[j][0] = v[i][0];
				      v[i][0] = aux;
				      aux = v[j][1];
				      v[j][1] = v[i][1];
				      v[i][1] = aux;
				}	
			}
			i++;
		}
	}
	
	private static void ordenMenorAMayor(int [][] v){
		int i=0, f=1, aux;
		while(i<v.length && f==1){
			f=0;
			for(int j=0; j<v.length-1; j++){
				if(v[i][1]>v[j][1]){
					f=1;
					aux = v[j][0];
				      v[j][0] = v[i][0];
				      v[i][0] = aux;
				      aux = v[j][1];
				      v[j][1] = v[i][1];
				      v[i][1] = aux;
				}	
			}
			i++;
		}
	}

}
