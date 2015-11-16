package grafo;

import java.util.Random;

public class Coloreo {
	private int [][] elementos;
	private int [][] mat;
	
	public Coloreo(GrafoNDNP g){
		elementos = new int [g.getOrden()][3];
		for(int i = 0; i<elementos.length;i++){
			elementos[i][0]=i;
			elementos[i][1]=g.getGrado(i);
		}
	}
	
	public int [][] getMatriz(){
		return mat;
	}
	
	public int secuencial(GrafoNDNP g){
		mat = getMatrizCopia(elementos);
		mezclar(mat);
		return colorear(mat, g);
	}
	
	public int welshPowell(GrafoNDNP g){
		mat = getMatrizCopia(elementos);
		mezclar(mat);
		ordenMenorAMayor(mat);
		return colorear(mat, g);
	}
	
	public int matula(GrafoNDNP g){
		mat = getMatrizCopia(elementos);
		mezclar(mat);
		ordenMayorAMenor(mat);
		return colorear(mat, g);
	}
	
	private int [][] getMatrizCopia(int [][] m){
		mat = new int [m.length][m[0].length];
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[0].length; j++)
				mat[i][j] = m[i][j];
		
		return mat;
	}
	
	private static int colorear(int [][] elementos, GrafoNDNP g){
		int[] colores = new int [g.getOrden()];
		int color;
		elementos[0][3]=1;
		for(int i = 0; i<g.getOrden(); i++){
			color =1;
			for(int j = 0; j<g.getOrden(); i++)
				if(g.getAdyacencia(i, elementos[j][0]) && elementos[j][3]==color){
					color++;
					sumarColor(color, colores);
				}
			elementos[i][3]=color;
		}
		
		return contarColores(colores);
	}
	
	private static void sumarColor(int  color, int [] colores){
		int i=0;
		while(i<colores.length && colores[i]!=0)
			i++;		
		if(i<colores.length)
			colores[i]=i;
	}
	private static int contarColores(int [] colores){
		int cont=0;
		for(int i=0; i<colores.length; i++){
			if(colores[i]!=0)
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
