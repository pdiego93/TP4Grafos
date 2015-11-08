package probador;

import java.util.*;

public class App {

	public static void main(String[] args) {
		ProbadorGrafos p = new ProbadorGrafos("grafo.in", "coloreado.out");
		Calendar ti = new GregorianCalendar();
		p.resolver();
		Calendar tf = new GregorianCalendar();
		long dif = tf.getTimeInMillis() - ti.getTimeInMillis();
		System.out.println("Tiempo de respuesta: " + dif + " ms.");
	}

}
