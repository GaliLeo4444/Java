package Objetos;


public class CD {


//	Atributos

	private String nombre; 
	private String interprete;
	private int duracion; 
	private int anio;
	private String genero;


//	Constructor

	public CD(String nombre, String interprete, int duracion, int anio, String genero) {
		super();
		this.nombre = nombre;
		this.interprete = interprete;
		this.duracion = duracion;
		this.anio = anio;
		this.genero = genero;
	}


//	Comandos

	public void setAno(int ano) {
			this.anio = ano;
	}

	public void setDuracion(int duracion) {
			this.duracion = duracion;
	}

	public void setGenero(String genero) {
			this.genero = genero;
	}

	public void setInterprete(String interprete) {
			this.interprete = interprete;
	}

	public void setNombre(String nombre) {
			this.nombre = nombre;
	}


//	 Consulta

	public int getAno() {
		return anio;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getGenero() {
		return genero;
	}

	public String getInterprete() {
		return interprete;
	}

	public String getNombre() {
		return nombre;
	}


}
