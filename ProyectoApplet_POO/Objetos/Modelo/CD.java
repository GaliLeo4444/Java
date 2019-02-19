package Objetos.Modelo;
import java.util.LinkedList;

/**
 * La clase CD representa una secuencia finita de pistas. Brinda servicios para agregar, modificar y eliminar elementos de un CD.
 */

public class CD {


//	Atributos

	private String nombre; 
	private String interprete;
	private int duracion; 
	private int a�o;
	private String genero;
	private LinkedList<Cancion> ListaTemas;  	 


//	Constructor
	/**
	 * Crea un CD vac�o.
	 */
	public CD() {
		super();
	}
	
	/**
	 * Crea un CD.
	 * @param interprete Nombre del Artista
	 * @param nombre Nombre del Album
	 * @param genero Nombre del g�nero
	 * @param a�o A�o del CD
	 * @param duracion Duracion del Disco 
	 */
	public CD(String nombre, String interprete, int duracion, int a�o, String genero) {
		super();
		this.nombre = nombre;
		this.interprete = interprete;
		this.duracion = duracion;
		this.a�o = a�o;
		this.genero = genero;
		this.ListaTemas = new LinkedList<Cancion>(); // Agregar operaciones 
	}

//	 Consulta
	
	public int cantidadCanciones() {
		return (ListaTemas.size());
	}
	
	/**
	 * Retorna el a�o del CD.
	 * @return
	 */
	public int getA�o() {
		return a�o;
	}

	public int getDuracion() {
		return duracion;
	}
	
	/**
	 * Retorna el g�nero del CD.
	 * @return
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Retorna el interprete del CD.
	 * @return
	 */
	public String getInterprete() {
		return interprete;
	}

	/**
	 * Retorna el nombre del CD.
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	public Cancion obtenerCancion(int pista) {	//Hacer una exception
		return (ListaTemas.get(pista));
	}

//	Comandos
	
	public void setA�o(int a�o) {
			this.a�o = a�o;
	}
	/**
	 * Modifica la duracion de un CD
	 * @param duracion
	 */
	public void setDuracion(int duracion) {
			this.duracion = duracion;
	}

	/**
	 * Modifica el g�nero.
	 * @param genero Nombre del g�nero
	 */
	public void setGenero(String genero) {
			this.genero = genero;
	}
 
	/**
	 * Modifica el nombre del autor.
	 * @param interprete Nombre del autor
	 */
	public void setInterprete(String interprete) {
			this.interprete = interprete;
	}
	
	/**
	 * Modifica el nombre del album.
	 * @param nombre Nombre del album
	 */
	public void setNombre(String nombre) {
			this.nombre = nombre;
	}


}
