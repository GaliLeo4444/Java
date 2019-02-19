package implementacion;


import java.io.*;


public class Ruta {
	
	
	private String fullPath;	
	private final String separadorDeCarp = File.separator;
	
	/**
	 * Este es el constructor de la clase
	 */
	public Ruta(){		
	}
	
	/**
	 * Este constructor crea una ruta con la direccion de dir
	 * Este puede ser un archivo o carpeta
	 * @param dir Una direccion de archivo/carpeta
	 */
	public Ruta(String dir){
		this.fullPath=dir;
	}
	
	/**
	 * Asigna a la ruta, la direccion especificada
	 * @param ruta Una direccion de archivo/carpeta
	 */
	public void setPath(String ruta){
		this.fullPath=ruta;
	}
	
	/**
	 * Este servicio, nos devuelve una cadena con la ruta actual
	 * @return retorna en un String, el path del archivo actual
	 */
	public String getFullPath(){
		return(this.fullPath);
	}
	
	/**
	 * Este servicio devuelve una cadena con la ubicacion del archivo actual
	 * sin incluir al archivo
	 * @return El path del archivo actual
	 */
	public String getPathDeArchivo(){
		int sep;
		sep = fullPath.lastIndexOf(this.separadorDeCarp);
		return ( fullPath.substring(0, sep+1));
	}
	
	/**
	 * Este servicio devuelve una cadena con la ubicacion de la carpeta actual
	 * sin incluir la carpeta
	 * @return El path de la carpeta actual
	 */
	public String getPathDeCarpeta(){
		int sep;
		sep = fullPath.lastIndexOf(this.separadorDeCarp, fullPath.length()-2);	//Saltea la última barra del path
		if (sep != -1)
			{return ( fullPath.substring(0, sep+1));}
		else {return(fullPath);}	//No tiene directorio padre
	}

	/**
	 * Retorna la extensión del archivo actual
	 * @return La extension del archivo actual
	 */
	public String getExtension(){
		int punto;
		punto = fullPath.lastIndexOf(".");
		if (punto != -1)
			{return ( fullPath.substring(punto+1));}
		else {return("");}
	}
	
	/**
	 * Retorna el nombre del archivo actual sin incluir su extension
	 * @return El nombre del archivo actual
	 */
	public String getNomArchivo(){
		int sep;
		int punto;
		sep = fullPath.lastIndexOf(this.separadorDeCarp);
		punto = fullPath.lastIndexOf(".");
		if ((punto > -1) && (sep<punto)){
			return (fullPath.substring(sep+1, punto));
		}
		else { 
			if (sep>-1){
				return(fullPath.substring(sep+1));
			}
			else {
				return("");
			}
		}
	}
	
	/**
	 * Retorna el nombre de la carpeta actual sin incluir a su directorio padre
	 * @return El nombre de la carpeta actual
	 */
	public String getNomCarpeta(){
		int sep;
		sep = fullPath.lastIndexOf(this.separadorDeCarp);
		if (sep != -1){
			return (fullPath.substring(sep+1, fullPath.length()));
		}
		else {return("");}
	}

	/**
	 * Retorna el nombre de la carpeta actual, ya sea de un archivo o de la carpeta
	 * final de la ruta
	 * @return El nombre de la carpeta actual
	 */
	public String getDirActual(){
		int ult_barra, penult_barra;
		ult_barra = fullPath.lastIndexOf(this.separadorDeCarp);
		penult_barra = fullPath.lastIndexOf(this.separadorDeCarp, ult_barra-1);
		return (fullPath.substring(penult_barra+1, ult_barra));
	}
}
