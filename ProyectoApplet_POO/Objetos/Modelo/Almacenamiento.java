package Objetos.Modelo;
import java.util.LinkedList;





public class Almacenamiento {


// 	Atributos	

	private LinkedList<CD> ListaCDs;
	private int pos;


//	Constructor
	/**
	 * Crea un Almacenamiento vacío.
	 */	
	public Almacenamiento() {
		super();
		this.ListaCDs = new LinkedList<CD>();
		pos = 0;
	}


// 	Comandos
	/**
	 * Añade un nuevo CD al Almacenamiento.
	 * @param disco CD a agregar
	 */
	public void AgregarCD(CD disco){
		this.ListaCDs.addLast(disco); // agrega al final de la lista	
	}
	
	/**
	 * Elimina un CD del Almacenamiento.
	 * @param disco CD a eliminar
	 */
	public void QuitarCD(CD disco){
		this.ListaCDs.remove(disco);	
	}
	
	public void PrimerCD() {
		pos = 0;
	}
	
	public void SiguienteCD() {
		pos = pos + 1;		
	} 
	
	public void AnteriorCD() {
		pos = pos - 1;	
	}

	public void FinalCD(){
		
	}


//	Consultas
    /** Retorna un CD de la posicion i
     * @param i int Posicion en el almacenamiento
     */
	public CD RetornarCD(int i) {
		
		return ListaCDs.get(i);
	}
	/** Retorna un CD de la posicion pos
     * @param 
     */
	public CD RetornarCD() {
		return ListaCDs.get(pos);
	}
	/**
	 * Busca un cd del almacenamiento por su nombreCD
	 * @param nombreCD Nombre el CD en cuestion
	 * @return
	 */
	
	public CD BuscarCD(String nombreCD) {
		int pista = 0;
		int cant;
		CD actualCD = null;
	    Boolean Encontre = false; 
		
		cant = ListaCDs.size();
		while ((pista < cant) && (!(Encontre))) {
			actualCD = ListaCDs.get(pista);
			if (nombreCD.equals(actualCD.getNombre()))
				{Encontre= true;}
			else {pista ++;}
		}
		if (!Encontre)
			{actualCD=null;}
		return actualCD;
	}

	
	/**
	 * Devuelve true si existen CDs en el Almacenamiento; false en caso contrario.
	 * @return
	 */
	public boolean AlmacenamientoVacio(){
		return (ListaCDs.size() == 0);
	}
	
	/**
	 * Retorna un conjunto de CDs asociados al nombre del album.
	 * @param NombreCD Nombre del album
	 * @return 
	 */
	public Almacenamiento BuscarPorAlbum(String nombreCD) {
	int pista = 0;
	int cant;
	CD actualCD = null;
	Almacenamiento  A = new Almacenamiento();
		cant = ListaCDs.size();
		while (pista < cant) {
			actualCD = ListaCDs.get(pista);
			if (nombreCD == actualCD.getNombre())
				{A.AgregarCD(actualCD);}
			pista ++;			
			}		
		return A;
		
	}
		
	/**
	 * Retorna un conjunto de CDs asociados al nombre del artista.
	 * @param NombreArtista Nombre del artista
	 * @return 
	 */
	
	public  CD[] BuscarPorArtista(String NombreArtista) {
		int pista = 0;
		int cant,i;
		CD actualCD = null;
		CD[] Aux = new CD[100];    
		i=0;		
		cant = ListaCDs.size();
		while (pista < cant) {
			actualCD = ListaCDs.get(pista);
			if (NombreArtista.equals(actualCD.getInterprete()))
				{Aux[i]= actualCD;
				i+=1;}
			
			pista +=1;
		}
		return Aux;
	}
	/**  
	 * Devuelve la cantidad de CD en el almacenamiento
	 * @return
	 */
	public int CantidadCD() {
	return ListaCDs.size();	
	} 


}


