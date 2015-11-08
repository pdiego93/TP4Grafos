package probador;

import java.io.File;

public abstract class Archivos {
	protected File entrada;
	protected File salida;

	public Archivos(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}

	public abstract void resolver();
}
