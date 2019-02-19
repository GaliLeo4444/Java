package Objetos;

public class Cancion {

//	Atributos

	private StringBuffer nombre;
	private int duracion;
	private int numeropista;


//	Constructor	

	public Cancion(StringBuffer nombre, int duracion, int numeropista) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numeropista = numeropista;
	}


//	 Comandos

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setNombre(StringBuffer nombre) {
		this.nombre = nombre;
	}

	public void setNumeropista(int numeropista) {
		this.numeropista = numeropista;
	}


//	 Consultas	

	public int getDuracion() {
		return duracion;
	}

	public StringBuffer getNombre() {
		return nombre;
	}

	public int getNumeropista() {
		return numeropista;
	}
}
