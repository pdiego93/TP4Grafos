package grafo;

public class GrafoNDNP extends MatrizSimetrica{
	protected int[][] colores;
	protected int[][] coloresTotS;
	protected int[][] coloresTotWP;
	protected int[][] coloresTotM;
	protected int [] coloreados;
	protected int cantColores;
	protected int cantAristas;
	protected int porcAdy;
	protected int gradoMax;
	protected int gradoMin;

	public GrafoNDNP(int nodos) {
		super(nodos);
		this.colores = new int[nodos][2];
		coloreados = new int[nodos];
		coloresTotS = new int[nodos][2];
		coloresTotWP = new int[nodos][2];
		coloresTotM = new int[nodos][2];
	}
	
	public GrafoNDNP() {
		super();
	}	

	public void setCantNodos(int nodos) {
		this.tam = nodos;
		this.colores = new int[nodos][2];
	}
	
	public int getCantColores() {
		return cantColores;
	}

	public void setCantColores(int cantColores) {
		this.cantColores = cantColores;
	}

	public void setColor(int nodo, int color){
		this.colores[nodo][0] = color;
	}
	
	public int getColor(int i){
		return this.colores[i][0];
	}
	public int getColorTot(int i, int tipo){
		if(tipo==1)
			return this.coloresTotS[i][0];
		if(tipo == 2)
			return this.coloresTotWP[i][0];
		
			return this.coloresTotM[i][0];
	}
	
	public void setColorNodo(int nodo, int color){
		coloreados[nodo]=color;
	}
	
	public int getColorNodo(int nodo){
		return coloreados[nodo];
	}
	public int getCantRepColor(int i){
		return colores[i][1];
	}
	public int getCantRepColorTot(int i, int tipo){
		if(tipo==1)
			return this.coloresTotS[i][1];
		if(tipo == 2)
			return this.coloresTotWP[i][1];
		
		return this.coloresTotM[i][1];
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
		//colores = col.getColores();
		sumarColoresTotales(cantColores, 1);
	}
	
	public void welshPowell(){
		Coloreo col = new Coloreo(this);
		//col.mezclar();
		col.ordenMayorAMenor();
		cantColores = col.colorear(this);
		//colores = col.getColores();
		sumarColoresTotales(cantColores, 2);
	}
	
	public void matula(){
		Coloreo col = new Coloreo(this);
		//col.mezclar();
		col.ordenMenorAMayor();
		cantColores = col.colorear(this);
		//colores = col.getColores();
		sumarColoresTotales(cantColores, 3);
	}
	
	private void sumarColoresTotales(int cantColores, int met){
		int j=0;
		if(met==1){
		while(j<coloresTotS.length && coloresTotS[j][0]!=0 && coloresTotS[j][0] != cantColores)
			j++;		
			if(j<coloresTotS.length){
				if(coloresTotS[j][0]==0)
					coloresTotS[j][0]=cantColores;

				coloresTotS[j][1]++;
			
			}
		}
		if(met==2){
			while(j<coloresTotWP.length && coloresTotWP[j][0]!=0 && coloresTotWP[j][0] != cantColores)
				j++;		
				if(j<coloresTotWP.length){
					if(coloresTotWP[j][0]==0)
						coloresTotWP[j][0]=cantColores;

					coloresTotWP[j][1]++;
				
				}
		}
		
		if(met==3){
			while(j<coloresTotM.length && coloresTotM[j][0]!=0 && coloresTotM[j][0] != cantColores)
				j++;		
				if(j<coloresTotM.length){
					if(coloresTotM[j][0]==0)
						coloresTotM[j][0]=cantColores;

					coloresTotM[j][1]++;
				
				}
		}
	}
	
	
	
	public void reiniciarColoresTot(){
		coloresTotS = new int[this.getCantNodos()][2];
		coloresTotWP = new int[this.getCantNodos()][2];
		coloresTotM = new int[this.getCantNodos()][2];
		Coloreo.ReiniciarMatColores();
	}
	
	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}
	
}
