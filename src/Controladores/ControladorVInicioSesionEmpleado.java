package Controladores;

import Excepciones.ExistException;
import Main.Empleado;
import Modulos.ModuloPrincipal;
import Ventanas.MenuEmpleado;
import Ventanas.MenuPrincipal;

public class ControladorVInicioSesionEmpleado {
	private ModuloPrincipal modulo;
	
	public ControladorVInicioSesionEmpleado(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/**************** | Función verificarEmpleado() | *****************/
	/* El proposito de esta función es verificar si el usuario existe *
	 * en los datos recibidos por los csv dentro de las colecciones   *
	 * a partir de un rut y luego verifica si la contraseña es la	  *
	 * misma.														  *
	 * Recibe un rut y una password.								  *
	 * Retorna true si es que es realmente el empleado o false en     *
	 * caso contrario.												  */
	public boolean verificarEmpleado(String rut, String password) throws ExistException {
		Empleado auxEmpleado = modulo.getEmpleadoRut(rut);
		
		if(auxEmpleado == null) {
			throw new ExistException();
		}
		if(!password.equals(auxEmpleado.getPassword())) return false;
		
		return true;
	}
	
	/************* | Función botonAcceder() | **************/
	/* El proposito de esta función es inicializar el      *
	 * empleado actual a partir del rut entregado y lo     *
	 * envía a la ventana menu empleado.				   *
	 * Recibe un rut.                                      *
	 * No retorna valores.                                 */
	public void botonAcceder(String rut) {
		Empleado aux = modulo.getEmpleadoRut(rut);
		
		modulo.setEmpleadoActual(aux);
		MenuEmpleado.main(null, modulo);
	}

	public void botonVolver() {
		MenuPrincipal.main(null, modulo);
	}
}
