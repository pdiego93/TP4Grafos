package generador;
import grafo.*;

public class MainGenerador {

	public static void main(String[] args) {
		MatrizSimetrica mat = new MatrizSimetrica(5);
		GrafoNDNP g = new GrafoNDNP(6);
		Generador.regularGrado(g, 6, 2);
		for(int i =0;i<g.getMaxAristas();i++)
			System.out.println(g.getIndices(i)[0] + " " + g.getIndices(i)[1] + " " + g.getAdyacencia(g.getIndices(i)[0],g.getIndices(i)[1]));
		
		
		
		/*
			MatrizSimetrica mat = new MatrizSimetrica(5);
			mat.setAdyacente(0, 1); // 0
//			mat.setAdyacente(0, 2); // 1
			mat.setAdyacente(0, 3); // 2
//			mat.setAdyacente(0, 4); // 3
			mat.setAdyacente(1, 2); // 4
//			mat.setAdyacente(1, 3); // 5
			mat.setAdyacente(1, 4); // 6
			mat.setAdyacente(2, 3); // 7
//			mat.setAdyacente(2, 4); // 8
			mat.setAdyacente(3, 4); // 9

			boolean[][] matriz_entera = new boolean[5][5];
			
			for(int j = 0; j < 5; j++)
				matriz_entera[j][j] = false;
			
			for(int i = 0; i <= 9; i++){
				boolean valor = mat.getAdyacente(i);
				int[] indices = mat.getPos(i);
				matriz_entera[indices[0]][indices[1]] = valor;
				matriz_entera[indices[1]][indices[0]] = valor;
			}
			
			for(int f = 0; f<5; f++){
				for(int c = 0; c<5; c++)
					System.out.print((matriz_entera[f][c]?"X":"O")+"  ");
				System.out.print("\n");
			}
			
			
			int grado = 0;
			
			for(int f = 0; f<5; f++){
				for(int c = 0; c<5; c++)
					if(matriz_entera[f][c])
						grado++;
				System.out.println("Fila "+f+": "+grado);
				grado = 0;
			}
			
			
			
//			int pos = mat.getPos(0, 1);
//			System.out.println(pos);
//			pos = mat.getPos(0, 2);
//			System.out.println(pos);
//			pos = mat.getPos(0, 3);
//			System.out.println(pos);
//			pos = mat.getPos(0, 4);
//			System.out.println(pos);
//			pos = mat.getPos(1, 2);
//			System.out.println(pos);
//			pos = mat.getPos(1, 3);
//			System.out.println(pos);
//			pos = mat.getPos(1, 4);
//			System.out.println(pos);
//			pos = mat.getPos(2, 3);
//			System.out.println(pos);
//			pos = mat.getPos(2, 4);
//			System.out.println(pos);
//			pos = mat.getPos(3, 4);
//			System.out.println(pos);
	//
//			int[] ij = mat.getPos(0);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(1);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(2);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(3);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(4);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(5);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(6);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(7);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(8);
//			System.out.println(ij[0] + " " + ij[1]);
//			ij = mat.getPos(9);
//			System.out.println(ij[0] + " " + ij[1]);
		}*/
	}

}

