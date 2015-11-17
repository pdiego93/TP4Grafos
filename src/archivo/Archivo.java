package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import grafo.GrafoNDNP;

public class Archivo {

	public static GrafoNDNP leerGrafo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cantNodos, cantAristas, porcAdy, gradoMax, gradoMin;
		GrafoNDNP g = null; 
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			cantNodos = Integer.parseInt(linea[0]);
			cantAristas = Integer.parseInt(linea[1]);
			porcAdy = Integer.parseInt(linea[2]);
			gradoMax = Integer.parseInt(linea[3]);
			gradoMin = Integer.parseInt(linea[4]);
			
			g = new GrafoNDNP(cantNodos);
			g.setCantAristas(cantAristas);
			g.setPorcAdy(porcAdy);
			g.setGradoMax(gradoMax);
			g.setGradoMin(gradoMin);
			
			for (int i = 0; i < cantNodos; i++) {
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
		
		return g;
	}

	public static void escribirGrafo(GrafoNDNP g, String ruta) {
		FileWriter fw;
		PrintWriter pw = null;
		int orden = g.getCantNodos(), cantAristas = g.getCantAristas(), gradoMin = g
				.getGrado(0), gradoMax = g.getGrado(0), aux;

		double porc = (g.getCantAristas() / g.getMaxAristas()) * 100;

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
			pw.println(orden + " " + cantAristas + " " + porc
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

	public static void escribirGrafoColoreado(GrafoNDNP g, String ruta) {
		FileWriter fw;
		PrintWriter pw = null;
		int cantNodos = g.getCantNodos(), 
				gradoMin = g.getGrado(0),
				gradoMax = g.getGrado(0),
				aux;
		

		for (int i = 1; i < cantNodos; i++) {
			aux = g.getGrado(i);
			if (aux < gradoMin)
				gradoMin = aux;
			if (aux > gradoMax)
				gradoMax = aux;
		}
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(cantNodos + " " + g.getCantColores() + " " + g.getCantAristas() + " " + g.getPorcAdy()
					+ " " + gradoMax + " " + gradoMin);
			for (int i = 0; i < cantNodos; i++)
				pw.println((i) + " " + g.getColor(i));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
	
	
	
	
	public static GrafoNDNP leerGrafoColoreado(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cantNodos, cantColores, cantAristas, porcAdy, gradoMax, gradoMin;
		GrafoNDNP g = null; 
		
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String[] linea = br.readLine().split(" ");
			cantNodos = Integer.parseInt(linea[0]);
			cantColores = Integer.parseInt(linea[1]);
			cantAristas = Integer.parseInt(linea[2]);
			porcAdy = Integer.parseInt(linea[3]);
			gradoMax = Integer.parseInt(linea[4]);
			gradoMin = Integer.parseInt(linea[5]);
			
			g = new GrafoNDNP(cantNodos);
			g.setCantNodos(cantNodos);
			g.setCantColores(cantColores);
			g.setCantAristas(cantAristas);
			g.setPorcAdy(porcAdy);
			g.setGradoMax(gradoMax);
			g.setGradoMin(gradoMin);
			
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
		
		return g;
	}
}
