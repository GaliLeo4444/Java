package interfaz;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import implementacion.ManejadorDeArchivos;
import implementacion.Ruta;
import java.io.*;
import java.util.Vector;
import javax.swing.table.JTableHeader;


/**
 * Esta clase redefine a la clase JTable
 * y la adapta para la visualización de archivos.
 */
public class Tabla extends JTable{


	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;
	private JTableHeader encabezados;
	private ManejadorDeArchivos MDA;
	
	
	/**
	 * Es el constructor de la clase.
	 * Elimina las líneas de separación entre celdas y fija las columnas.
	 */
	public Tabla(){
		super();
		this.showHorizontalLines = false;
		this.showVerticalLines = false;
		encabezados = this.getTableHeader();
		encabezados.setReorderingAllowed(false);
		MDA = new ManejadorDeArchivos();
	}
	

	/**
	 * Evita que las celdas se puedan editar.
	 */
	public boolean isCellEditable (int row, int column)
	{
	   return (false);
	}
	
	/**
	 * Dada una Ruta de carpeta, carga su contenido a la tabla.
	 * @param carpeta La ruta de dónde se obtienen los archivos y carpetas para llenar la tabla.
	 * @throws IOException
	 */
	public void asociarModeloConRuta (Ruta carpeta) throws IOException{
		File carpetaActual, archivoActual;
		Vector<String> atributos;
		modelo = new DefaultTableModel(null, new String[] {"Nombre", "Extensión", "Tamaño", "Fecha modificación"});
		carpetaActual = new File(carpeta.getFullPath());
		String contenido[] = carpetaActual.list();
		if (contenido != null){			
			int tope = contenido.length;
			int i = 0;
			Ruta rutaActual;
			while (i < tope){
				atributos = new Vector<String>(4, 1);
				rutaActual = new Ruta(carpeta.getFullPath()+contenido[i]);
				archivoActual = new File(rutaActual.getFullPath());
				if (archivoActual.exists()){
					if (archivoActual.isDirectory()){
						atributos.add("[ " +contenido[i]+ " ]");	//Nombre
						atributos.add("< DIR >");					//Extención
						atributos.add("");							//Tamaño
						atributos.add("");							//Fecha de modificación
					}
					else {
						atributos.add(rutaActual.getNomArchivo()+"."+rutaActual.getExtension());
						atributos.add(rutaActual.getExtension());
						atributos.add(MDA.tamanioArchivo(new Ruta(carpeta.getFullPath()+contenido[i])));
						atributos.add(MDA.fechaModArchComun(rutaActual));
					}
					modelo.addRow(atributos);
				}
				i++;
			}
		}
		this.setModel(modelo);
	}

	/**
	 * Ordena el modelo de la tabla por nombre o extención en forma ascendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param col Indica por qué columna hay que ordenar, columna nombre (0) ó columna extención (1).
	 */
	private void burbujaAscParaNomOExt (Vector<Vector<String>> datos, int col){
		int i, j;
		String dat1, dat2;
		Vector<String> temp;
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				dat1 = datos.get(j-1).get(col);
				dat2 = datos.get(j).get(col);
				if (dat1.compareToIgnoreCase(dat2) < 0){
					temp = datos.get(j-1);
					datos.set(j-1, datos.get(j));
					datos.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * Ordena el modelo de la tabla por nombre o extención en forma descendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param col Indica por qué columna hay que ordenar, columna nombre (0) ó columna extención (1).
	 */
	private void burbujaDescParaNomOExt (Vector<Vector<String>> datos, int col){
		int i, j;
		String dat1, dat2;
		Vector<String> temp;
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				dat1 = datos.get(j-1).get(col);
				dat2 = datos.get(j).get(col);
				if (dat1.compareToIgnoreCase(dat2) > 0){
					temp = datos.get(j-1);
					datos.set(j-1, datos.get(j));
					datos.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * Ordena el modelo de la tabla por tamaño en forma ascendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param direct Es el directorio padre de todos los archivos actuales de la tabla.
	 * @throws IOException
	 */
	private void burbujaAscParaTamanio (Vector<Vector<String>> datos, String direct) throws IOException{
		int i, j;
		long dat1, dat2;
		boolean es_carpeta;
		Ruta ruta1 = new Ruta();
		Ruta ruta2 = new Ruta();
		Vector<String> temp;
		burbujaAscParaNomOExt(datos, 0);		//Se ponen las carpetas al principio de la tabla
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				es_carpeta = datos.get(j-1).get(0).startsWith("[ ") || datos.get(j).get(0).startsWith("[ ");
				if (! es_carpeta){
					ruta1.setPath(direct + datos.get(j-1).get(0));
					ruta2.setPath(direct + datos.get(j).get(0));
					dat1 = MDA.tamanioArchivoEnBytes(ruta1);
					dat2 = MDA.tamanioArchivoEnBytes(ruta2);
					if (dat1 < dat2){
						temp = datos.get(j-1);
						datos.set(j-1, datos.get(j));
						datos.set(j, temp);
					}
				}
			}
		}
	}

	/**
	 * Ordena el modelo de la tabla por tamaño en forma descendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param direct Es el directorio padre de todos los archivos actuales de la tabla.
	 * @throws IOException
	 */
	private void burbujaDescParaTamanio (Vector<Vector<String>> datos, String direct) throws IOException{
		int i, j;
		long dat1, dat2;
		boolean es_carpeta;
		Ruta ruta1 = new Ruta();
		Ruta ruta2 = new Ruta();
		Vector<String> temp;
		burbujaAscParaNomOExt(datos, 0);		//Se ponen las carpetas al principio de la tabla
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				es_carpeta = datos.get(j-1).get(0).startsWith("[ ") || datos.get(j).get(0).startsWith("[ ");
				if (! es_carpeta){
					ruta1.setPath(direct + datos.get(j-1).get(0));
					ruta2.setPath(direct + datos.get(j).get(0));
					dat1 = MDA.tamanioArchivoEnBytes(ruta1);
					dat2 = MDA.tamanioArchivoEnBytes(ruta2);
					if (dat1 > dat2){
						temp = datos.get(j-1);
						datos.set(j-1, datos.get(j));
						datos.set(j, temp);
					}
				}
			}
		}
	}

	/**
	 * Ordena el modelo de la tabla por fecha en forma ascendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param direct Es el directorio padre de todos los archivos actuales de la tabla.
	 * @throws IOException
	 */
	private void burbujaAscParaFecha (Vector<Vector<String>> datos, String direct) throws IOException{
		int i, j;
		long dat1, dat2;
		boolean es_carpeta;
		Ruta ruta1 = new Ruta();
		Ruta ruta2 = new Ruta();
		Vector<String> temp;
		burbujaAscParaNomOExt(datos, 0);		//Se ponen las carpetas al principio de la tabla
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				es_carpeta = datos.get(j-1).get(0).startsWith("[ ") || datos.get(j).get(0).startsWith("[ ");
				if (! es_carpeta){
					ruta1.setPath(direct + datos.get(j-1).get(0));
					ruta2.setPath(direct + datos.get(j).get(0));
					dat1 = MDA.fechaModArchEnMilis(ruta1);
					dat2 = MDA.fechaModArchEnMilis(ruta2);
					if (dat1 < dat2){
						temp = datos.get(j-1);
						datos.set(j-1, datos.get(j));
						datos.set(j, temp);
					}
				}
			}
		}
	}

	/**
	 * Ordena el modelo de la tabla por fecha en forma descendente. 
	 * @param datos Es el modelo de la tabla que contiene todas las filas y columnas.
	 * @param direct Es el directorio padre de todos los archivos actuales de la tabla.
	 * @throws IOException
	 */
	private void burbujaDescParaFecha (Vector<Vector<String>> datos, String direct) throws IOException{
		int i, j;
		long dat1, dat2;
		boolean es_carpeta;
		Ruta ruta1 = new Ruta();
		Ruta ruta2 = new Ruta();
		Vector<String> temp;
		burbujaAscParaNomOExt(datos, 0);		//Se ponen las carpetas al principio de la tabla
		for (i = datos.size(); i > 0; i--){
			for (j = 1; j < i; j++){
				es_carpeta = datos.get(j-1).get(0).startsWith("[ ") || datos.get(j).get(0).startsWith("[ ");
				if (! es_carpeta){
					ruta1.setPath(direct + datos.get(j-1).get(0));
					ruta2.setPath(direct + datos.get(j).get(0));
					dat1 = MDA.fechaModArchEnMilis(ruta1);
					dat2 = MDA.fechaModArchEnMilis(ruta2);
					if (dat1 > dat2){
						temp = datos.get(j-1);
						datos.set(j-1, datos.get(j));
						datos.set(j, temp);
					}
				}
			}
		}
	}

	/**
	 * Se encarga de obtener el modelo de la tabla para luego llamar a 
	 * un método de ordenamiento correspondiente.
	 * Luego vuelve a poner el modelo a la tabla.
	 * @param ascendente Forma a ordenar (si es true es ascendente, si es false es descendente).
	 * @param columna Es la columna por la cuál se debe ordenar el modelo de la tabla.
	 * @param directorio Es el directorio padre de todos los archivos actuales de la tabla,
	 * que se necesita para ordenar correctamente por tamaño y por fecha de modificación.
	 * @throws IOException
	 */
	public void ordenarPor (boolean ascendente, int columna, String directorio) throws IOException{
		modelo = (DefaultTableModel) this.getModel();
		Vector<Vector<String>> filas;
		int i;
		filas =  (Vector<Vector<String>>) modelo.getDataVector();
		modelo = new DefaultTableModel(null, new String[] {"Nombre", "Extensión", "Tamaño", "Fecha modificación"});
		if (ascendente){
			switch (columna) {
		      	case 0: burbujaAscParaNomOExt(filas, columna);
		    	  	break;
		      	case 1: burbujaAscParaNomOExt(filas, columna);
	    	  		break;
		      	case 2: burbujaAscParaTamanio(filas, directorio);
	    	  		break;
		      	case 3: burbujaAscParaFecha(filas, directorio);
	  				break;
			}
		}
		else {
			switch (columna) {
	      		case 0: burbujaDescParaNomOExt(filas, columna);
	    	  		break;
	      		case 1: burbujaDescParaNomOExt(filas, columna);
    	  			break;
	      		case 2: burbujaDescParaTamanio(filas, directorio);
    	  			break;
	      		case 3: burbujaDescParaFecha(filas, directorio);
  					break;
			}
		}
		i = filas.size();
		while (i > 0){
			modelo.addRow((Vector<String>) filas.get(i-1));
			i--;
		}
		this.setModel(modelo);
	}


}