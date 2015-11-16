package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import grafo.GrafoNDNP;

public class Archivo {

	public static void leerGrafo(GrafoNDNP g, String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data;
		int orden, cantAristas, porcAdy, gMax, gMin;
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String[] linea = br.readLine().split(" ");
			orden = Integer.parseInt(linea[0]);
			cantAristas = Integer.parseInt(linea[1]);
			porcAdy = Integer.parseInt(linea[2]);
			gMax = Integer.parseInt(linea[3]);
			gMin = Integer.parseInt(linea[4]);
			for (int i = 0; i < orden; i++) {
				linea = br.readLine().split(" ");
				g.setAdyacencia(Integer.parseInt(linea[0]),
						Integer.parseInt(linea[1]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void escribirGrafoColoreado(GrafoNDNP g, String ruta,
			int[] colores) {
		FileWriter fw;
		PrintWriter pw = null;
		int orden = g.getOrden(), cantAristas = g.cantidadAristas(), gradoMin = g
				.getGrado(0), gradoMax = g.getGrado(0), aux, cantCol = colores.length;

		double porc = (g.cantidadAristas() / g.getMaxAristas()) * 100;

		for (int i = 1; i < orden; i++) {
			aux = g.getGrado(i);
			if (aux < gradoMin)
				gradoMin = aux;
			if (aux > gradoMax)
				gradoMax = aux;
		}
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(orden + " " + cantCol + " " + cantAristas + " " + porc
					+ " " + gradoMax + " " + gradoMin);
			for (int i = 0; i < orden; i++)
				for (int j = i + 1; j < orden; j++)
					if (g.getAdyacencia(i, j))
						pw.println(i + " " + j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	public static void leerGrafoColoreado(GrafoNDNP g, String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data;
		int cantNodos, cantColores, cantAristas, porcAdy, gMax, gMin;
		
		//N CCol  CA %Ady GrMax GrMin
		//Nodo Color
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String[] linea = br.readLine().split(" ");
			cantNodos = Integer.parseInt(linea[0]);
			cantColores = Integer.parseInt(linea[1]);
			cantAristas = Integer.parseInt(linea[2]);
			porcAdy = Integer.parseInt(linea[3]);
			gMax = Integer.parseInt(linea[4]);
			gMin = Integer.parseInt(linea[5]);
			for (int i = 0; i < cantNodos; i++) {
				linea = br.readLine().split(" ");
				g.setColor(Integer.parseInt(linea[0]),
						Integer.parseInt(linea[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
