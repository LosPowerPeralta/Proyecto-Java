package Controladores;

import Main.Persona;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;
import Ventanas.RegistroCliente;
import Excepciones.ExistException;

public class ControladroVInicioSesionUsuario {
	private ModuloPrincipal modulo;
	
	public ControladroVInicioSesionUsuario(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/***************** | Función verificarUsuario() | ****************/
	/* El proposito de esta función es verificar si existe un 		 *
	 * usuario o no a partir de un nombre y rut.					 *
	 * Recibe un nombre y un rut.									 *
	 * Retorna true si es que encuentra un usuario con los mismos	 *
	 * datos o en caso contrario false.								 */
	public boolean verificarUsuario(String nombre, String rut) throws ExistException {
		Persona auxPersona = modulo.getClienteRut(rut);
		
		if(auxPersona == null) {
			throw new ExistException();
		}
		if(!nombre.equals(auxPersona.getNombre())) return false;
		
		return true;
	}
	
	/************** | Función botonAcceder() | **************/
	/* El proposito de esta función es obtener el cliente   *
	 * actual a patir de un rut e inicializarlo dentro del	*
	 * modulo, luego de esto el usuario es enviado a la 	*
	 * ventana menú cliente.								*
	 * Recibe un rut.										*
	 * No retorna valores.									*/
	public void botonAcceder(String rut) {
		Persona aux = modulo.getClienteRut(rut);
		
		modulo.setClienteActual(aux);
		MenuCliente.main(null, modulo);
	}

	public void botonRegistrarse() {
		RegistroCliente.main(null, modulo);
	}
}
