package implementacion;


import java.awt.Desktop;
import java.io.*;
import java.util.Calendar;
import java.util.Vector;
import java.nio.channels.FileChannel;


public class ManejadorDeArchivos {


	private Vector<Ruta> Temporal;
	private char accion;


		/**
		 * Es el constructor de la clase
		 */
		public ManejadorDeArchivos(){
			Temporal = new Vector<Ruta>(5,2);
		}


		/**
		 * Este procedimiento crea una carpeta. 
		 * Si los directorios padres de la carpeta no est�n creados tambi�n se crean.
		 * Si la carpeta ya existe, no la crea.
		 * @param DirPadre Directorio donde ser� creada la carpeta. 
		 * @param NombreDir Nombre que llevar� la carpeta.
		 */
		public void CrearCarpeta(Ruta DirPadre, String NombreDir){
			File carpeta = new File(DirPadre.getFullPath() + NombreDir);
			carpeta.mkdirs();
		}

		/**
		 * Este procedimiento crea un nuevo archivo de texto.
		 * Si lel directorio del archivo no est� creado tambi�n se crea.
		 * @param DirPadre Directorio d�nde ser� creado el nuevo archivo.
		 * @param Nombre Nombre que llevar� el nuevo archivo.
		 * @throws IOException, multipleExcepcion
		 */
		public void CrearArchivoTexto(Ruta DirPadre, String Nombre) throws IOException, multipleExcepcion {
				File comprobar = new File(DirPadre.getFullPath() + Nombre);
				if (!comprobar.exists()){
					File carpeta = new File(DirPadre.getFullPath());
					carpeta.mkdirs();
					FileOutputStream archivo = new FileOutputStream(DirPadre.getFullPath() + Nombre);
					archivo.close();
				}
				else {
					throw new multipleExcepcion("Ya existe ese nombre!!!!");
				}
		}
	
		/**
		 * Este procedimiento copia archivos y carpetas de un origen a un destino.
		 * Si el/los archivo/s exite/n, se sobreescribe/n.
		 * @param origen Elementos a los cu�les se les debe realizar la copia.
		 * @param destino Lugar donde se copiar�n los elementos origen.
		 * @throws IOException, multipleExcepcion
		 */
		public void hacerCopia(Vector<Ruta> origen, Ruta destino) throws IOException, multipleExcepcion{
				int i=0;
				int tope = origen.size();
				FileInputStream o;
				FileOutputStream d;
				File archDestino = new File(destino.getPathDeArchivo());
				if (!archDestino.exists()){
					archDestino.mkdirs();					
				}
				while (i<tope){
				File archOrigen = new File( origen.get(i).getFullPath() );
				if (archOrigen.exists()){
					if (!archOrigen.isDirectory()){
						archDestino = new File(destino.getFullPath());
						if (!archDestino.exists()){
							archDestino.mkdirs();					
						};
						o = new FileInputStream(origen.get(i).getFullPath());
						File comprDestino = new File (destino.getFullPath()+origen.get(i).getNomArchivo()+"."+origen.get(i).getExtension());
						if (!comprDestino.exists()){
							d = new FileOutputStream(destino.getFullPath()+origen.get(i).getNomArchivo()+"."+origen.get(i).getExtension());
							FileChannel canalFuente = o.getChannel(); 
							FileChannel canalDestino = d.getChannel(); 
							canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
							o.close(); 
							d.close();
						}
						else {
							
							if (archOrigen.equals(comprDestino)){
								int cont=0;
								boolean pude=false;
								while ( cont<1000 && !pude){
									cont++;
									comprDestino = new File(destino.getFullPath()+origen.get(i).getNomArchivo()+"("+cont+")"+"."+origen.get(i).getExtension());
									if (! comprDestino.exists()){
										pude=true;
									}
								}
								if (!pude){
									throw new multipleExcepcion("La cantidad de archivos repetidos supera el limite de 1000. No se seguir�n haciendo copias");
								}
								else{
									d = new FileOutputStream(comprDestino);
									FileChannel canalFuente = o.getChannel(); 
									FileChannel canalDestino = d.getChannel(); 
									canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
									o.close(); 
									d.close();
								}
							}
						}
						
					}
					else{
							Ruta dest;
							Ruta dirOrigen= new Ruta(origen.get(i).getFullPath()+File.separator);
							archDestino = new File(destino.getFullPath());
							if (!archDestino.exists()){
								archDestino.mkdirs();					
							}
							if (dirOrigen.getPathDeCarpeta().equals(destino.getFullPath())){
								int cont=0;
								boolean pude=false;
								while ( cont<1000 && !pude){
									cont++;
									archDestino = new File(origen.get(i).getFullPath()+"("+cont+")");
									if (! archDestino.exists()){
										pude=true;
									}
								}
								if (!pude){
									throw new multipleExcepcion("La cantidad de carpetas repetidas supera el limite de 1000. No se seguir�n haciendo copias");
								}
								else{
									dest = new Ruta(archDestino.getPath()+File.separator);
								}
							}
							else{
								dest = new Ruta(destino.getFullPath()+dirOrigen.getDirActual()+File.separator);
							}
				    		String interiores[] = archOrigen.list();
				    		int busqInterior=0;
				    		Vector<Ruta> dirs= new Vector<Ruta>(5,2);
				    		while (busqInterior<interiores.length){
				    			Ruta rutaDeCopia= new Ruta(archOrigen.getPath()+File.separator+interiores[busqInterior]);
				    			dirs.add(rutaDeCopia);
				    			busqInterior++;
				    		}
				    		hacerCopia(dirs, dest );
				    }
				}
				i++;
				}
			 }
	
		/**
		 * Este procedimiento elimina varios archivos o carpetas. 
		 * @param elegidos Las rutas de los archivos elegidos para su eliminaci�n.
		 * @throws SecurityException
		 */
		public void EliminarVarios(Vector<Ruta> elegidos) throws SecurityException{
			int i=0;
			int tope = elegidos.size();
			File archElegido;
			while (i<tope){
				archElegido= new File(elegidos.get(i).getFullPath());
				if (archElegido.exists()){
					Eliminar(elegidos.get(i));
				}
				i++;
			}
		}
	
		/**
		 * Este procedimiento elimina un archivo o carpeta
		 * @param elegido La ruta del elemento elegido para ser eliminado.
		 * @throws SecurityException
		 */
		public void Eliminar(Ruta elegido) throws SecurityException{
				File borrame = new File (elegido.getFullPath());
				if (borrame.isDirectory()){
					String contenido[] = borrame.list();
					int i=0;
					while(i< contenido.length ){
						Ruta r = new Ruta(elegido.getFullPath()+File.separator+contenido[i].toString());
						Eliminar(r);
						i++;
					}
				};
				borrame.delete();
		}

		/**
		 * Guarda en memoria las rutas de archivos o carpetas.
		 * Este espacio en memoria pude ser accedido por "Pegar" para hacer una
		 * copia de los elementos en un lugar deseado.
		 * @param Direcciones Las direcciones que se guardaran para hacer la copia.
		 */
		public void Copiar (Vector<Ruta> Direcciones){
			accion='c';
			Temporal = Direcciones;
		}

		/**
		 * Guarda en memoria las rutas de archivos o carpetas.
		 * Este espacio en memoria pude ser accedido por "Pegar" para 
		 * mover los elementos hacia un lugar deseado.
		 * @param Direcciones Las direcciones que se guardaran para mover.
		 */
		public void Cortar (Vector<Ruta> Direcciones){
			accion='x';
			Temporal = Direcciones;
		}

		/**
		 * Mueve vaios archivos o carpetas desde una ruta de origen a una de destino.
		 * @param origen Elementos que se desea mover.
		 * @param destino Lugar a d�nde se mover�n los elementos de origen.
		 * @throws IOException, SecurityException
		 */
		public void Mover (Vector<Ruta> origen, Ruta destino) throws IOException, SecurityException {
			int i=0;
			int tope = origen.size();
			FileInputStream o;
			FileOutputStream d;
			File archDestino = new File(destino.getPathDeArchivo());
			if (!archDestino.exists()){
				archDestino.mkdirs();					
			}
			while (i<tope){
			File archOrigen = new File( origen.get(i).getFullPath() );
			if (archOrigen.exists()){
				if (!archOrigen.isDirectory()){
					archDestino = new File(destino.getFullPath());
					if (!archDestino.exists()){
						archDestino.mkdirs();					
					};
					o = new FileInputStream(origen.get(i).getFullPath());
					File comprDestino = new File (destino.getFullPath()+origen.get(i).getNomArchivo()+"."+origen.get(i).getExtension());
					if (!comprDestino.exists()){
						d = new FileOutputStream(destino.getFullPath()+origen.get(i).getNomArchivo()+"."+origen.get(i).getExtension());
						FileChannel canalFuente = o.getChannel(); 
						FileChannel canalDestino = d.getChannel(); 
						canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
						o.close(); 
						d.close();
					}
				}
				else{
						Ruta dest;
						Ruta dirOrigen= new Ruta(origen.get(i).getFullPath()+File.separator);
						archDestino = new File(destino.getFullPath());
						if (!dirOrigen.getPathDeCarpeta().equals(destino.getFullPath())){
							if (!archDestino.exists()){
								archDestino.mkdirs();					
							}
							dest = new Ruta(destino.getFullPath()+dirOrigen.getDirActual()+File.separator);						
							String interiores[] = archOrigen.list();
							int busqInterior=0;
							Vector<Ruta> dirs= new Vector<Ruta>(5,2);
							while (busqInterior<interiores.length){
								Ruta rutaDeCopia= new Ruta(archOrigen.getPath()+File.separator+interiores[busqInterior]);
								dirs.add(rutaDeCopia);
								busqInterior++;
							}
							Mover(dirs, dest );
						}
			    	}
				}
				archOrigen.delete();
				i++;
			}

		}

		/**
		 * Dependiendo de la funcion quye se haya ejecutado con anterioridad,
		 * se copian o mueven los elementos gurdados en memoria a la ubicacion destino.
		 * @param Destino Ruta del lugar a donde se pegaran los elementos elegidos anteriormente.
		 * @throws IOException, SecurityException
		 */
		public void Pegar (Ruta Destino) throws IOException, SecurityException, multipleExcepcion{
			if (accion == 'c'){
				hacerCopia(Temporal, Destino);
			}
			if (accion == 'x'){
				Mover(Temporal, Destino);
				accion = 'n';
			}
		}

		/**
		 * Renombra el archivo con NombreViejo que esta en el Lugar especificado
		 * para que tenga el NombreNuevo.
		 * @param Lugar El lugar donde se encuentra el archivo.
		 * @param NombreViejo El nombre viejo del archivo.
		 * @param NombreNuevo El nombre nuevo del archivo.
		 * @throws IOException
		 */
		public void RenombrarArchivo (Ruta Lugar, String NombreViejo, String NombreNuevo) throws IOException, multipleExcepcion {
				File Viejo = new File(Lugar.getFullPath() + File.separator + NombreViejo);
				File Nuevo = new File(Lugar.getFullPath() + File.separator + NombreNuevo);
				if (!Nuevo.exists()){
					boolean OK = Viejo.renameTo(Nuevo);
					if (!OK){
						throw new IOException();
					}
				}
				else {
					throw new multipleExcepcion("El nombre ya existe");
				}
		}

		/**
		 * Convierte un numero expersado en bytes a la unidad correspondiente y devuelve un
		 * String con el numero y las unidades: Bytes, KB, MB o GB.
		 * @param cantidad Un tama�o en bytes
		 * @return Un string con el tama�o en la unidad adecuada
		 */
		private String convertirDeBytesA (long cantidad){
			if (cantidad < 1024){
				return(String.valueOf(cantidad) + " Bytes");
			}
			else
				{
				cantidad = cantidad/1024;
				if (cantidad < 1024){
					return(String.valueOf(cantidad) + " KB");
				}
				else
					{
					cantidad = cantidad/1024;
					if (cantidad < 1024){
						return(String.valueOf(cantidad) + " MB");
					}
					else
						{
						cantidad = cantidad/1024;
						return(String.valueOf(cantidad) + " GB");
						}
					}
				}
		}

		/**
		 * Devuelve el tama�o del archivo que se encuentra en la ubicaci�n dada.
		 * Si el archivo no existe o es una carpeta devuelve un string vacio.
		 * @param rutArchivo Ruta donde se encuentra el archivo.
		 * @return Un String con el tama�o del archivo en Bytes, KB, MB o GB dependiendo del caso.
		 * @throws IOException
		 */
		public String tamanioArchivo(Ruta rutArchivo) throws IOException{
			File arch = new File(rutArchivo.getFullPath());
			if (arch.exists()){
				return (convertirDeBytesA(arch.length()));
			}
			else {
				throw new IOException();
			}
		}

		/**
		 * Devuelve el tama�o de la carpeta que se encuentra en la ruta dada.
		 * Si la carpeta no existe devuelve 0.
		 * @param rutaCarpeta Es la ruta de la carpeta a examinar.
		 * @return long El tama�o de la carpeta en Bytes.
		 * @throws IOException
		 */
		private long calcularTamanioCarpeta(Ruta rutaCarpeta) throws IOException{
			File arch = new File(rutaCarpeta.getFullPath());
			if (arch.exists()){
				if (arch.isDirectory()){
					long suma = 0;
					String contenido[] = arch.list();
					int i = 0;
					while (i < contenido.length){
						Ruta r = new Ruta(rutaCarpeta.getFullPath() + File.separator + contenido[i]);
						suma = suma + calcularTamanioCarpeta(r);
						i++;
					}
					return (suma);
				}
				else {
					return (arch.length());
				}
			}
			else{
				throw new IOException();
			}
		}

		/**
		 * Devuelve el tama�o del archivo que se encuentra en la ruta dada.
		 * Si el archivo no existe devuelve 0.
		 * @param rutaCarpeta Es la ruta del archivo a examinar.
		 * @return Un entero long con el tama�o del archivo en Bytes.
		 * @throws IOException
		 */
		public long tamanioArchivoEnBytes(Ruta rutaArchivo) throws IOException{
			File arch = new File(rutaArchivo.getFullPath());
			if (arch.exists()){
				if (!arch.isDirectory()){
					return (arch.length());
				}
				else{
					return(0);
				}
			}
			else {
				throw new IOException();
			}
		}

		/**
		 * Devuelve el tama�o de la carpeta que se encuentra en la ruta dada.
		 * Si la carpeta no existe devuelve un string vacio.
		 * @param rutaCarpeta Es la ruta de la carpeta a examinar.
		 * @return Un String con el tama�o del archivo en Bytes, KB, MB o GB dependiendo del caso.
		 * @throws IOException
		 */
		public String tamanioCarpeta (Ruta rutaCarpeta) throws IOException{
			File arch = new File(rutaCarpeta.getFullPath());
			if (arch.exists()){
				return (convertirDeBytesA(calcularTamanioCarpeta(rutaCarpeta)));
			}
			else {
				throw new IOException();
			}
		}

		/**
		 * Esta operaci�n abre un archivo ejecutable con ruta arch.
		 * @param arch La ruta del archivo ejecutable a abrir.
		 * @throws IOException
		 */
		public void Abrir (Ruta arch) throws IOException{
			File objetivo = new File(arch.getFullPath());
			if (objetivo.exists()){
					Desktop.getDesktop().open(objetivo);
				
			}
		}

		/**
		 * Esta operaci�n recupera la fecha de modificaci�n de un archivo.
		 * Si es carpeta devuelve una cadena vac�a.
		 * @param rutaArch	Es la ruta del archivo a consultar.
		 * @return Un String con la forma dia / mes / a�o.
		 * @throws IOException
		 */
		public String fechaModArchComun (Ruta rutaArch) throws IOException{
			File arch = new File(rutaArch.getFullPath());
			if (arch.exists()){
				if (! arch.isDirectory()){
					Calendar C = Calendar.getInstance();
					C.setTimeInMillis(arch.lastModified());
					return (String.valueOf(C.get(Calendar.DATE))+" / "+String.valueOf((C.get(Calendar.MONTH))+1)+" / "+String.valueOf(C.get(Calendar.YEAR)));
				}
				else {
					return("");
				}
			}
			else {
				throw new IOException();
			}
		}

		/**
		 * Esta operaci�n recupera la fecha de modificaci�n de un archivo.
		 * Si es carpeta devuelve 0.
		 * @param rutaArch	Es la ruta del archivo a consultar.
		 * @return La fecha de modificaci�n del archivo en milisegundos.
		 * @throws IOException
		 */
		public long fechaModArchEnMilis (Ruta rutaArch) throws IOException{
			File arch = new File(rutaArch.getFullPath());
			if (arch.exists()){
				if (! arch.isDirectory()){
					Calendar C = Calendar.getInstance();
					C.setTimeInMillis(arch.lastModified());
					return (C.getTimeInMillis());
				}
				else {
					return(0);
				}
			}
			else {
				throw new IOException();
			}
		}


}
