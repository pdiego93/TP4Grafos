package grafo;

import java.util.Random;

public class Coloreo {
	private int [][] elementos;
	
	public Coloreo(GrafoNDNP g){
		elementos = new int [g.getOrden()][3];
		for(int i = 0; i<elementos.length;i++){
			elementos[i][0]=i;
			elementos[i][1]=g.getGrado(i);
		}
	}
	
	public int [][] getMatriz(){
		return elementos;
	}
	
	public int secuencial(GrafoNDNP g){
		int [][] mat = getMatrizCopia(elementos);
		mezclar(mat);
		return colorear(mat, g);
	}
	
	public int welshPowell(GrafoNDNP g){
		int [][] mat = getMatrizCopia(elementos);
		mezclar(mat);
		ordenMenorAMayor(mat);
		return colorear(mat, g);
	}
	
	public int matula(GrafoNDNP g){
		int [][] mat = getMatrizCopia(elementos);
		mezclar(mat);
		ordenMayorAMenor(mat);
		return colorear(mat, g);
	}
	
	private static int [][] getMatrizCopia(int [][] m){
		int [][] mat = new int [m.length][m[0].length];
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[0].length; j++)
				mat[i][j] = m[i][j];
		
		return mat;
	}
	
	private static int colorear(int [][] elementos, GrafoNDNP g){
		boolean[] colores = new boolean [g.getOrden()];
		int color;
		elementos[0][3]=1;
		for(int i = 0; i<g.getOrden(); i++){
			color =1;
			for(int j = 0; j<g.getOrden(); i++)
				if(g.getAdyacencia(i, elementos[j][0]) && elementos[j][3]==color)
					color++;
			
			elementos[i][3]=color;
		}
		
		return contarColores(colores);
	}
	
	private static int contarColores(boolean [] colores){
		int cont=0;
		for(int i=0; i<colores.length; i++){
			if(colores[i])
				cont++;
		}
		return cont;		
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
