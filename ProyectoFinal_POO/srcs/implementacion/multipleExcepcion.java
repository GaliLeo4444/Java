package implementacion;


/**
 * Es una excepci�n personalizada la cu�l recibe un string al ser creada
 * y puede ser usada para comunicar al usuario los distintos
 * errores ocurridos.
 * @author Administrador
 *
 */
public class multipleExcepcion  extends Exception {


	private static final long serialVersionUID = 1L;


	public multipleExcepcion (String mensaje){
		super(mensaje);
	}


}