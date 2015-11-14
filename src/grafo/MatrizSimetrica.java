package grafo;

public class MatrizSimetrica {
	private boolean [] vector = null;
	private int tam;
	
	public MatrizSimetrica(int n) {
		tam = n;
		vector = new boolean[n * (n - 1) / 2];
	}
	
	public boolean getAdyacencia(int i, int j) {
		return vector[this.getPos(i, j)];
	}

	public int getPos(int i, int j) {
		int aux;
		if (i > j) {
			aux = i;
			i = j;
			j = aux;
		}
		int pos = j - 1;
		for (int k = 1; k <= i; k++)
			pos += tam - k - 1;
		pos = i ==j ? -1 : pos; 
		return pos;
	}
	
	public void setAdyacencia(int i, int j) {
		System.out.println(i + " " + j);
		vector[this.getPos(i, j)] = true;
		//System.out.println(vector[this.getPos(i, j)]);
	}

	public int getOrden() {
		return tam;
	}

	public int getMaxAristas() {
		return tam*(tam - 1)/2;
	}

	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = tam*(tam - 1)/2;
		for(int i = 0; i < maxAristas; i++)
			if(vector[i])
				aristas++;
		return aristas;
	}

	public int getGrado(int nodo) {
		int grado = 0;
		for(int i = 0; i < tam; i++)
			if(i!=nodo)
				if(vector[this.getPos(i, nodo)]){
					grado++;
				}
		return grado;
	}
	
	public int[] getIndices(int pos) {
		int k = 1;
		while (pos >= tam - k) {
			pos -= tam - k;
			k++;
		}
		return new int[]{k-1,k+pos};
	}
	
	public void setAdyacencia(int pos) {
		vector[pos] = true;
	}

	public boolean getAdyacencia(int pos) {
		return vector[pos];
	}
	
	public boolean todosMismoGrado(int grado){
		int i;
		for(i=0; i<vector.length;i++)
			if(this.getGrado(i)!=grado)
				return false;
		
		return true;
	}
}

