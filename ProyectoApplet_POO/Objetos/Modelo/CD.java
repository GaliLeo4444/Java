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
	private int año;
	private String genero;
	private LinkedList<Cancion> ListaTemas;  	 


//	Constructor
	/**
	 * Crea un CD vacío.
	 */
	public CD() {
		super();
	}
	
	/**
	 * Crea un CD.
	 * @param interprete Nombre del Artista
	 * @param nombre Nombre del Album
	 * @param genero Nombre del género
	 * @param año Año del CD
	 * @param duracion Duracion del Disco 
	 */
	public CD(String nombre, String interprete, int duracion, int año, String genero) {
		super();
		this.nombre = nombre;
		this.interprete = interprete;
		this.duracion = duracion;
		this.año = año;
		this.genero = genero;
		this.ListaTemas = new LinkedList<Cancion>(); // Agregar operaciones 
	}

//	 Consulta
	
	public int cantidadCanciones() {
		return (ListaTemas.size());
	}
	
	/**
	 * Retorna el año del CD.
	 * @return
	 */
	public int getAño() {
		return año;
	}

	public int getDuracion() {
		return duracion;
	}
	
	/**
	 * Retorna el género del CD.
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
	
	public void setAño(int año) {
			this.año = año;
	}
	/**
	 * Modifica la duracion de un CD
	 * @param duracion
	 */
	public void setDuracion(int duracion) {
			this.duracion = duracion;
	}

	/**
	 * Modifica el género.
	 * @param genero Nombre del género
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
