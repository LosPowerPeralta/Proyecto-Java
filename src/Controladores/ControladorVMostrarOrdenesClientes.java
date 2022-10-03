package Controladores;

import javax.swing.table.DefaultTableModel;
import Main.Persona;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;

public class ControladorVMostrarOrdenesClientes {
	
	private ModuloPrincipal modulo;
	
	public ControladorVMostrarOrdenesClientes(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public void botonVolver() {
		MenuCliente.main(null, modulo);
		
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

}
