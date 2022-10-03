package Controladores;

import javax.swing.table.DefaultTableModel;

import Excepciones.ConvertException;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Main.Persona;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;

public class ControladorVBuscarPorCriterio {
	private ModuloPrincipal modulo;

	public ControladorVBuscarPorCriterio(ModuloPrincipal modulo) {
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
		Persona clienteActual = modulo.getClienteActual();
		OrdenDeTrabajo auxOrden;
		Empleado empleado;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		for(int i = 0; i < clienteActual.getSizeListOrden(); i++) {
			auxOrden = clienteActual.getListOrden(i);
			empleado = auxOrden.getEmpleado();
			datosFilas[0] = clienteActual.getNombre();
			datosFilas[1] = empleado.getNombre();
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
	 * id, dispositivo o empleado.										  *
	 * Recibe un boolean id, dispositivo y empleado, además recibe un     *
	 * filtro.		  													  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatoModel(boolean id, boolean dispositivo, boolean empleado, String busqueda) throws ConvertException {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre Cliente", "Nombre Empleado", "Dispositivo", "Diagnostico", "Descripcion", "Estado", "Total", "ID"};
		String datosFilas[] = new String[8];
		Persona clienteActual = modulo.getClienteActual();
		OrdenDeTrabajo auxOrden;
		Empleado empleadoAux;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		if(!busqueda.matches("[0-9]+") && id) {
			throw new ConvertException();
		}
		
		for(int i = 0; i < clienteActual.getSizeListOrden(); i++) {
			auxOrden = clienteActual.getListOrden(i);
			if(id) {
				if(auxOrden.getId() == Integer.parseInt(busqueda)) {
					empleadoAux = auxOrden.getEmpleado();
					datosFilas[0] = clienteActual.getNombre();
					datosFilas[1] = empleadoAux.getNombre();
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
					empleadoAux = auxOrden.getEmpleado();
					datosFilas[0] = clienteActual.getNombre();
					datosFilas[1] = empleadoAux.getNombre();
					datosFilas[2] = auxOrden.getDispositivo();
					datosFilas[3] = auxOrden.getDiagnostico();
					datosFilas[4] = auxOrden.getDescripcion();
					datosFilas[5] = auxOrden.getEstado();
					datosFilas[6] = Integer.toString(auxOrden.getTotal());
					datosFilas[7] = Integer.toString(auxOrden.getId());
					
					modelo.addRow(datosFilas);
				}
			}
			if(empleado) {
				empleadoAux = auxOrden.getEmpleado();
				if(busqueda.equals(empleadoAux.getNombre())) {
					datosFilas[0] = clienteActual.getNombre();
					datosFilas[1] = empleadoAux.getNombre();
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

	public void botonVolver() {
		MenuCliente.main(null, modulo);
	}
}