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
		
		mat = getMatrizCopia(elementos);
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
	
	public int [][] getMatrizCopia(int [][] m){
		mat = new int [m.length][m[0].length];
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[0].length; j++)
				mat[i][j] = m[i][j];
		
		return mat;
	}
	
	public int colorear(GrafoNDNP g){
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
	
	public void mezclar(){
		Random rnd = new Random();
		int aux;
	    for (int i = 0; i < mat.length; i++)
	    {
	      int index = rnd.nextInt(i + 1);
	      
	      aux = mat[index][0];
	      mat[index][0] = mat[i][0];
	      mat[i][0] = aux;
	      aux = mat[index][1];
	      mat[index][1] = mat[i][1];
	      mat[i][1] = aux;
	    }
	}
	
	public void ordenMayorAMenor(){
		int i=0, f=1, aux;
		while(i<mat.length && f==1){
			f=0;
			for(int j=0; j<mat.length-1; j++){
				if(mat[i][1]<mat[j][1]){
					f=1;
					aux = mat[j][0];
				      mat[j][0] = mat[i][0];
				      mat[i][0] = aux;
				      aux = mat[j][1];
				      mat[j][1] = mat[i][1];
				      mat[i][1] = aux;
				}	
			}
			i++;
		}
	}
	
	public void ordenMenorAMayor(){
		int i=0, f=1, aux;
		while(i<mat.length && f==1){
			f=0;
			for(int j=0; j<mat.length-1; j++){
				if(mat[i][1]>mat[j][1]){
					f=1;
					aux = mat[j][0];
				      mat[j][0] = mat[i][0];
				      mat[i][0] = aux;
				      aux = mat[j][1];
				      mat[j][1] = mat[i][1];
				      mat[i][1] = aux;
				}	
			}
			i++;
		}
	}

}
