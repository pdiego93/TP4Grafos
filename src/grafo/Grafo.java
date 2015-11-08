package grafo;

public class Grafo {
	private boolean [] ady;
	private int orden;

	public Grafo(int nodos) {
		orden = nodos;
		ady = new boolean[orden*(orden - 1)/2];
	}

	private int conversion(int f, int c) {
		return f*orden+c-(f*f+3*f+2)/2;
	}

	public boolean getArista(int f, int c) {
		return ady[conversion(f, c)];
	}

	public int getFila(int i) { 
		return (int) (ady.length - (Math.ceil(1 + Math.sqrt(1+ 8 *(ady.length - i))))/ 2);
	}

	public int getColumna(int i) {
		return orden - (ady.length - i - ((orden - getFila(i) - 1) * 2 - (orden - getFila(i) - 1))/2);
	}

	public void setArista(int f, int c) {
		ady[conversion(f, c)] = true;
	}

	public void borrarArista(int f, int c) {
		ady[conversion(f, c)] = false;
	}

	public int getOrden() {
		return orden;
	}

	public int getMaxAristas() {
		return orden*(orden - 1)/2;
	}

	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = orden*(orden - 1)/2;
		for(int i = 0; i < maxAristas; i++)
			if(ady[i])
				aristas++;
		return aristas;
	}

	public int getGrado(int nodo) {
		int grado = 0;
		for(int i = 0; i < orden; i++)
			if(ady[conversion(nodo, i)])
				grado++;
		return grado;
	}

}
