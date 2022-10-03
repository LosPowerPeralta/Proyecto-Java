package Controladores;

import Modulos.ModuloPrincipal;
import Ventanas.InicioSesionUsuario;
import Main.Persona;
import Excepciones.ExistException;

public class ControladorVRegistroCliente {
	private ModuloPrincipal modulo;

	public ControladorVRegistroCliente(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/**************** | Función buscarUsuario() | **************/
	/* El proposito de esta función es buscar si existe o no   *
	 * un usuario con los datos indicados en la ventana.	   *
	 * Recibe un nombre y un rut.							   *
	 * Retrona true si existe el usuario o false en caso 	   *
	 * contrario.											   */
	public boolean buscarUsuario(String nombre, String rut) throws ExistException {
		Persona auxPersona = modulo.getClienteRut(rut);
		
		if(auxPersona == null) {
			throw new ExistException();
		}
		if(!nombre.equals(auxPersona.getNombre())) return false;
		
		return true;
	}

	/****************** | Función agregarUsuario() | ********************/
	/* El proposito de esta función es agregar un usuario a las         *
	 * colecciones  a partir de un nombre, rut, direccion y celular.    *
	 * Recibe un nombre, rut, dirección y celular.						*
	 * No retorna valores.												*/			
	public void agregarUsuario(String nombre, String rut, String direccion, String celular) {
		Persona newCliente = new Persona(nombre, rut, direccion, celular);
		
		modulo.agregarClienteName(newCliente);
		modulo.agregarClienteRut(newCliente);
		modulo.agregarListCliente(newCliente);		
	}

	public void botonVolver() {
		InicioSesionUsuario.main(null, modulo);
	}

}
