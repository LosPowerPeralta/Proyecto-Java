package Controladores;

import Ventanas.MenuEmpleado;
import Main.Empleado;
import Modulos.ModuloPrincipal;

public class ControladorVEditarDatosEmpleados {
	private ModuloPrincipal modulo; 
	
	public ControladorVEditarDatosEmpleados(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public String getNombreEmpleado() {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		return empleadoActual.getNombre();
	}
	
	public String getRutEmpleado() {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		return empleadoActual.getRut();
	}
	
	public String getDireccionEmpleado() {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		return empleadoActual.getDireccion();
	}
	
	public String getCelularEmpleado() {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		return empleadoActual.getCelular();
	}
	
	public String getPasswordEmpleado() {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		return empleadoActual.getPassword();
	}
	
	/***************** | Función actualizarDatos() | ************************/
	/* El proposito de esta función es actualizar los datos del empleado	*
	 * a partir de la dirección, celular y password dada por el usuario.    *
	 * Recibe una dirección, un número de celular y password.				*
	 * Retorn true si los datos fueron actualizados con éxito o false en    *
	 * caso contrario.														*/
	public boolean actualizarDatos(String direccion, String celular, String password) {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		empleadoActual.setDireccion(direccion);
		empleadoActual.setCelular(celular);
		empleadoActual.setPassword(password);
		
		if(!direccion.equals(empleadoActual.getDireccion())) return false;
		if(!celular.equals(empleadoActual.getCelular())) return false;
		if(!password.equals(empleadoActual.getPassword())) return false;
		
		return true;
	}

	public void botonVolver() {
		MenuEmpleado.main(null, modulo);
	}
}
