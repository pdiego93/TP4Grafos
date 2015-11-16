package grafo;

public class GrafoNDNP extends MatrizSimetrica{
	protected int[] colores;
	protected int cantColores;
	protected int porcAdy;
	protected int gradoMax;
	protected int gradoMin;

	public GrafoNDNP(int nodos) {
		super(nodos);
	}
	
	public int getCantColores() {
		return cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

	public void setColor(int nodo, int color){
		this.colores[nodo-1] = color;
	}
	
	public int getColor(int nodo){
		return this.colores[nodo-1];
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
	

	public int secuencial(GrafoNDNP g){
		Coloreo col = new Coloreo(g);
		col.mezclar();
		return col.colorear(g);
	}
	
	public int welshPowell(GrafoNDNP g){
		Coloreo col = new Coloreo(g);
		col.mezclar();
		col.ordenMayorAMenor();
		return col.colorear(g);
	}
	
	public int matula(GrafoNDNP g){
		Coloreo col = new Coloreo(g);
		col.mezclar();
		col.ordenMenorAMayor();
		return col.colorear(g);
	}
}
