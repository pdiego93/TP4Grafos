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
	
	public void secuencial(){
		Coloreo col = new Coloreo(this);
		col.mezclar();
		cantColores = col.colorear(this);
		colores = col.getColores();
	}
	
	public void welshPowell(){
		Coloreo col = new Coloreo(this);
		col.mezclar();
		col.ordenMayorAMenor();
		cantColores = col.colorear(this);
		colores = col.getColores();
	}
	
	public void matula(){
		Coloreo col = new Coloreo(this);
		col.mezclar();
		col.ordenMenorAMayor();
		cantColores = col.colorear(this);
		colores = col.getColores();
	}
	
	public void informeDeColores(int [] colores){
		int [][] inf = new int [colores.length][2];
		int j=0;
		
		for(int i = 0; i<colores.length;i++){
			j=0;
			while(j <inf.length && inf[j][0] != colores[i])
				j++;
				
			if(j<colores.length){
				inf[j][0] = colores[i];
				inf[j][1]++;
			}	
		}
		
		for(int i=0; i<inf.length; i++)
			//if(inf[i][0]!=0)
				System.out.println(inf[i][0]+ " "+ inf[i][1]);
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
}
