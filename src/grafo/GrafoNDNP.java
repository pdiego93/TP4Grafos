package grafo;

public class GrafoNDNP extends MatrizSimetrica{
	protected int[] colores;
	protected int cantColores;
	protected int cantAristas;
	protected int porcAdy;
	protected int gradoMax;
	protected int gradoMin;

	public GrafoNDNP(int nodos) {
		super(nodos);
		this.colores = new int[nodos];
	}
	
	public GrafoNDNP() {
		super();
	}	

	public void setCantNodos(int nodos) {
		this.tam = nodos;
		this.colores = new int[nodos];
	}
	
	public int getCantColores() {
		return cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

	public void setColor(int nodo, int color){
		this.colores[nodo] = color;
	}
	
	public int getColor(int nodo){
		return this.colores[nodo];
	}

	public int getPorcAdy() {
		return porcAdy;
	}

	public void setPorcAdy(int porcAdy) {
		this.porcAdy = porcAdy;
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public void setGradoMax(int gradoMax) {
		this.gradoMax = gradoMax;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public void setGradoMin(int gradoMin) {
		this.gradoMin = gradoMin;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
	
	
}
