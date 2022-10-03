package Controladores;

import javax.swing.table.DefaultTableModel;

import Main.Empleado;
import Main.OrdenDeTrabajo;
import Main.Persona;
import Modulos.ModuloPrincipal;
import Ventanas.MenuEmpleado;

public class ControladorVMostrarOrdenesEmpleados {
	private ModuloPrincipal modulo;

	public ControladorVMostrarOrdenesEmpleados(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/**************** | Función agregarDatosModel() | *********************/
	/* El proposito de esta función es es crear un nuevo modelo para la   *
	 * tabla utilizada en la ventana.									  *
	 * No recibe valores.												  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatoModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre Cliente", "Nombre Empleado", "Dispositivo", "Diagnostico", "Descripcion", "Estado", "Total", "ID"};
		String datosFilas[] = new String[8];
		Empleado empleadoActual = modulo.getEmpleadoActual();
		OrdenDeTrabajo auxOrden;
		Persona cliente;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		for(int i = 0; i < empleadoActual.getSizeListOrden(); i++) {
			auxOrden = empleadoActual.getListOrden(i);
			cliente = auxOrden.getUsuario();
			datosFilas[0] = cliente.getNombre();
			datosFilas[1] = empleadoActual.getNombre();
			datosFilas[2] = auxOrden.getDispositivo();
			datosFilas[3] = auxOrden.getDiagnostico();
			datosFilas[4] = auxOrden.getDescripcion();
			datosFilas[5] = auxOrden.getEstado();
			datosFilas[6] = Integer.toString(auxOrden.getTotal());
			datosFilas[7] = Integer.toString(auxOrden.getId());
			
			modelo.addRow(datosFilas);
		}
		
		return modelo;
	}
	
	/**************** | Función agregarDatosModel() | *********************/
	/* El proposito de esta función es es crear un nuevo modelo para la   *
	 * tabla utilizada en la ventana con un filtro que podría ser por	  *
	 * id, dispositivo o cliente.										  *
	 * Recibe un boolean id, dispositivo, cliente y además recibe un	  * 
	 * filtro.															  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatoModel(boolean id, boolean dispositivo, boolean cliente, String busqueda) {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre Cliente", "Nombre Empleado", "Dispositivo", "Diagnostico", "Descripcion", "Estado", "Total", "ID"};
		String datosFilas[] = new String[8];
		Empleado empleadoActual = modulo.getEmpleadoActual();
		OrdenDeTrabajo auxOrden;
		Persona auxCliente;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		for(int i = 0; i < empleadoActual.getSizeListOrden(); i++) {
			auxOrden = empleadoActual.getListOrden(i);
			if(id) {
				if(auxOrden.getId() == Integer.parseInt(busqueda)) {
					auxCliente = auxOrden.getUsuario();
					datosFilas[0] = auxCliente.getNombre();
					datosFilas[1] = empleadoActual.getNombre();
					datosFilas[2] = auxOrden.getDispositivo();
					datosFilas[3] = auxOrden.getDiagnostico();
					datosFilas[4] = auxOrden.getDescripcion();
					datosFilas[5] = auxOrden.getEstado();
					datosFilas[6] = Integer.toString(auxOrden.getTotal());
					datosFilas[7] = Integer.toString(auxOrden.getId());
					
					modelo.addRow(datosFilas);
				}
			}
			if(dispositivo) {
				if(busqueda.equals(auxOrden.getDispositivo())) {
					auxCliente = auxOrden.getEmpleado();
					datosFilas[0] = auxCliente.getNombre();
					datosFilas[1] = empleadoActual.getNombre();
					datosFilas[2] = auxOrden.getDispositivo();
					datosFilas[3] = auxOrden.getDiagnostico();
					datosFilas[4] = auxOrden.getDescripcion();
					datosFilas[5] = auxOrden.getEstado();
					datosFilas[6] = Integer.toString(auxOrden.getTotal());
					datosFilas[7] = Integer.toString(auxOrden.getId());
					
					modelo.addRow(datosFilas);
				}
			}
			if(cliente) {
				auxCliente = auxOrden.getEmpleado();
				if(busqueda.equals(auxCliente.getNombre())) {
					datosFilas[0] = auxCliente.getNombre();
					datosFilas[1] = empleadoActual.getNombre();
					datosFilas[2] = auxOrden.getDispositivo();
					datosFilas[3] = auxOrden.getDiagnostico();
					datosFilas[4] = auxOrden.getDescripcion();
					datosFilas[5] = auxOrden.getEstado();
					datosFilas[6] = Integer.toString(auxOrden.getTotal());
					datosFilas[7] = Integer.toString(auxOrden.getId());
					
					modelo.addRow(datosFilas);
				}
			}
		}
		
		return modelo;
	}
	
	/*********** | Función eliminarOrden() | **********/
	/* El proposito de esta función es eliminar una   *
	 * orden del modulo a partir de un id.			  *
	 * Recibe un id.								  *
	 * No retorna valores.							  */
	public void eliminarOrden(int id) {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		empleadoActual.eliminarOrden(id);
		modulo.eliminarOrden(id);
	}
	
	/************* | Función cambiarEstado | **************/
	/* El proposito de esta función es cambiar el estado  *
	 * de una orden a partir de un id recibido.	 		  *
	 * Recibe un id y el nuevo estado.					  *
	 * No retorna valores.								  */
	public void cambiarEstado(int id, String nuevoEstado) {
		Empleado empleadoActual = modulo.getEmpleadoActual();
		
		empleadoActual.cambiarEstadoOrden(id, nuevoEstado);
	}

	public void botonVolver() {
		MenuEmpleado.main(null, modulo);
	}
	
	public ModuloPrincipal getModulo() {
		return modulo;
	}
}
