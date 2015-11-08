package grafo;

public class GrafoNDNP extends MatrizSimetrica{

	public GrafoNDNP(int nodos) {
		super(nodos);
	}

	public int getCantNodos() {
		return getOrden();
	}

}
