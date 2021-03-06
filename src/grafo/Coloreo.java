package grafo;

import java.util.Arrays;
import java.util.Random;

public class Coloreo {
	private int [][] elementos;
	private static int [][] mat=null;
	private int [][] colores;
	
	public Coloreo(GrafoNDNP g){
		elementos = new int [g.getCantNodos()][3];
		for(int i = 0; i<elementos.length;i++){
			elementos[i][0]=i;
			elementos[i][1]=g.getGrado(i);
		}
		colores = new int [g.getCantNodos()][2];
		if(mat==null)
			mat = getMatrizCopia(elementos);
	}
		
	public int [][] getMatrizCopia(int [][] m){
		mat = new int [m.length][m[0].length];
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[0].length; j++)
				mat[i][j] = m[i][j];
		
		return mat;
	}
	


	public int colorear(GrafoNDNP g){
		int color, n, f;
		int [] col; 
		//mat[0][2]=1;
		for(int i = 0; i<g.getCantNodos(); i++){
			color =1;
			n = g.getGrado(mat[i][0]);
			col = new int [n];
			f=0;
			for(int j = 0; j<g.getCantNodos(); j++)
				if(mat[i][0] != mat[j][0] && g.getAdyacencia(mat[i][0], mat[j][0])){
					col[f]=mat[j][2];
					f++;
				}
			color = obtenerColor(col);
			mat[i][2]=color;
			g.setColorNodo(mat[i][0], color);
			sumarColor(color);
		}
		return contarColores();
	}
	
	private static int obtenerColor(int [] c){
		int color = 1;
		Arrays.sort(c);
		for(int i = 0; i<c.length;i++)
			if(color == c[i])
				color++;
		
		return color;
	}
	private void sumarColor(int  color){
		int i=0;
		while(i<colores.length && colores[i][0]!=0 && colores[i][0] != color)
			i++;		
		if(i<colores.length){
			if(colores[i][0]==0)
				colores[i][0]=color;

			colores[i][1]++;
		
		}
		
	}
	
	public void limpiarColores(){
		for(int i=0; i<mat.length;i++)
			mat[i][2]=0;
	}
	private int contarColores(){
		int cont=0;
		for(int i=0; i<colores.length; i++){
			if(colores[i][0]!=0)
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
				if(mat[j][1]<mat[j+1][1]){
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
				if(mat[j][1]>mat[j+1][1]){
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
	
	public int [][] getColores(){
		
		return colores;
	}
	
	public static void ReiniciarMatColores(){
		mat=null;
	}
}
