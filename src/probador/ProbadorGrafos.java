package probador;

import java.io.*;

public class ProbadorGrafos {
	private int [][] aristas;
	private String [] color;
	private int cA, nodos;
	
	public ProbadorGrafos(String in, String out) {
		
		FileReader archEnt = null, archSal = null;
		BufferedReader lectorEnt = null, lectorSal;
		try {
			archEnt = new FileReader(entrada);
			archSal = new FileReader(salida);
			lectorEnt = new BufferedReader(archEnt);
			lectorSal = new BufferedReader(archSal);
			String [] aux = lectorEnt.readLine().split(" ");
			nodos = Integer.parseInt(aux[0]);
			color = new String[nodos];
			cA = Integer.parseInt(aux[1]);
			aristas = new int[cA][2];
			for(int i = 0; i < cA; i++) {
				aux = lectorEnt.readLine().split(" ");
				aristas[i][0] = Integer.parseInt(aux[0]);
				aristas[i][1] = Integer.parseInt(aux[1]);
			}
			lectorSal.readLine();
			for(int i = 0; i < nodos; i++) {
				aux = lectorSal.readLine().split(" ");
				color[i] = aux[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				archEnt.close();
				archSal.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void resolver() {
		boolean casoCorrecto = true;
		for(int i = 0; i < cA; i++)
			casoCorrecto = !(color[aristas[i][0] - 1].equals(color[aristas[i][1] - 1]));
		System.out.println(casoCorrecto);
	}

}
