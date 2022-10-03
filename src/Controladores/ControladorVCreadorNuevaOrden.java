package Controladores;

import java.util.Random;

import Main.Persona;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;

public class ControladorVCreadorNuevaOrden {
	private ModuloPrincipal modulo;
	
	public ControladorVCreadorNuevaOrden(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/*********** | Función buscarEmpleado()  | *************/
	/* El proposito de esta función es buscar un empleado  *
	 * disponible para realizar una orden.				   *
	 * No recibe valores.								   *
	 * Retorna un empleado si es que puede recibir una     *
	 * nueva orden o en caso contrario retorna null.       */
	public Empleado buscarEmpleado() {
		Empleado empleado;
		int i;
		
		for(i = 0; i < modulo.getSizeEmpleados(); i++) {
			empleado = modulo.getEmpleado(i);
			
			if(empleado.getSizeListOrden() < 10) {
				return empleado;
			}
		}
		
		return null;
	}
	
	/**************** | Función agregarOrden() | ****************/
	/* El proposito de esta función es agregar una nueva orden  *
	 * a partir de un dispositivo y una descripción asignandole *
	 * un id y un empleado para el trabajo.					    *
	 * Recibe un dispositivo y una descripción.                 *
	 * Retorna true si la orden fue agregada con éxito o false  *
	 * en caso contrario.									    */
	public boolean agregarOrden(String dispositivo, String descripcion) {
		Random randomId = new Random();
		Persona clienteActual = modulo.getClienteActual();
		Empleado empleado = buscarEmpleado();
		OrdenDeTrabajo newOrden;
		int newId = randomId.nextInt(10000);
		
		while (modulo.getOrden(newId) != null) {
			if(modulo.getSizeEmpleados() == 1000) return false;
			newId = randomId.nextInt(10000);
		}
		
		newOrden = new OrdenDeTrabajo(clienteActual, empleado, dispositivo, descripcion, newId);
		clienteActual.agregarOrden(newOrden);
		empleado.agregarOrden(newOrden);
		modulo.agregarOrden(newOrden);
		
		return true;
	}

	public void botonVolver() {
		MenuCliente.main(null, modulo);
	}
	
}
