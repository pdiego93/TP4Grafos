package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import grafo.GrafoNDNP;

public class Archivo {
	
	public static void leer(GrafoNDNP g){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data;
		int orden, cantAristas, porcAdy, gMax, gMin;
		try {
			archivo = new File("Entrada//grafo.in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String [] linea = br.readLine().split(" ");
			orden = Integer.parseInt(linea[0]);
			cantAristas = Integer.parseInt(linea[1]);
			porcAdy = Integer.parseInt(linea[2]);
			gMax = Integer.parseInt(linea[3]);
			gMin = Integer.parseInt(linea[4]);
			for(int i = 0; i<orden;i++){
				linea = br.readLine().split(" ");
				g.setAdyacencia(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void escribir(GrafoNDNP g) {
		FileWriter fw;
		PrintWriter pw = null;
		int orden = g.getCantNodos(), 
			cantAristas = g.cantidadAristas(), 
			gradoMin = g.getGrado(0), 
			gradoMax = g.getGrado(0),
			aux;
		
		double porc = (g.cantidadAristas()/g.getMaxAristas())*100;
		
		for(int i = 1; i < orden; i++) {
			aux = g.getGrado(i);
			if(aux < gradoMin)
				gradoMin = aux;
			if(aux > gradoMax)
				gradoMax = aux;
		}
		try {
			fw = new FileWriter("Entradas//grafo.in");
			pw = new PrintWriter(fw);
			pw.println(orden + " " + cantAristas + " " + porc + " " + gradoMax + " " + gradoMin);
			for(int i = 0; i < orden; i++)
				for(int j = i + 1; j < orden; j++)
					if (g.getAdyacencia(i, j))
						pw.println(i + " " + j);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
