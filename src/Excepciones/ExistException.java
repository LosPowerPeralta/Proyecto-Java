package Excepciones;

/************* | Clase ExistExceptio | ************/
/* El proposito de esta clase es mostrar un       *
 * mensaje por cada error de ingreso a datos de   *
 * objetos nulos.								  */ 
public class ExistException extends Exception {
	public ExistException() {
		super("Variables Nula");
	}
 }
