package Excepciones;

/*************** | Clase convertException | ***************/
/* El proposito de esta clase es enviar un mensaje de     *
 * eror cada vez que encuentre un problema al convertir   *
 * un String a Int.										  */
public class ConvertException extends Exception {
	public ConvertException() {
		super("Error al pasar de String a entero.");
	}
}
