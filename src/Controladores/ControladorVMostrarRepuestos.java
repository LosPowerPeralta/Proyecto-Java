package Controladores;

import javax.swing.table.DefaultTableModel;
import Modulos.ModuloPrincipal;
import Main.Repuesto;
import Main.Inventario;
import Ventanas.MenuEmpleado;

public class ControladorVMostrarRepuestos {
	private ModuloPrincipal modulo;
	
	public ControladorVMostrarRepuestos(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	/**************** | Función agregarDatosModel() | *********************/
	/* El proposito de esta función es es crear un nuevo modelo para la   *
	 * tabla utilizada en la ventana.									  *
	 * No recibe valores.												  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatoModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre", "Cantidad", "Precio", "Id"};
		String datosFilas[] = new String[4];
		Inventario almacen = modulo.getInventario();
		Repuesto auxRepuesto;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		for(int i = 0; i < almacen.getSizeListRepuesto(); i++) {
			auxRepuesto = almacen.getListRepuesto(i);
			datosFilas[0] = auxRepuesto.getNombre();
			datosFilas[1] = Integer.toString(auxRepuesto.getCantidad());
			datosFilas[2] = Integer.toString(auxRepuesto.getPrecio());
			datosFilas[3] = Integer.toString(auxRepuesto.getId());
			
			modelo.addRow(datosFilas);
		}
		
		return modelo;
	}
	
	/**************** | Función agregarDatosModel() | *********************/
	/* El proposito de esta función es es crear un nuevo modelo para la   *
	 * tabla utilizada en la ventana con un filtro que podría ser por	  *
	 * id o nombre.														  *
	 * Recibe un boolean id y nombre, además recibe un filtro.			  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatoModel(boolean id, boolean nombre, String busqueda) {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre", "Cantidad", "Precio", "Id"};
		String datosFilas[] = new String[4];
		Inventario almacen = modulo.getInventario();
		Repuesto auxRepuesto;
		
		modelo.setColumnIdentifiers(columnas);
		modelo.setRowCount(0);
		
		for(int i = 0; i < almacen.getSizeListRepuesto(); i++) {
			auxRepuesto = almacen.getListRepuesto(i);
			if(id) {
				if(auxRepuesto.getId() == Integer.parseInt(busqueda)) {
					datosFilas[0] = auxRepuesto.getNombre();
					datosFilas[1] = Integer.toString(auxRepuesto.getCantidad());
					datosFilas[2] = Integer.toString(auxRepuesto.getPrecio());
					datosFilas[3] = Integer.toString(auxRepuesto.getId());
					
					modelo.addRow(datosFilas);
				}
			}
			if(nombre) {
				if(busqueda.equals(auxRepuesto.getNombre())) {
					datosFilas[0] = auxRepuesto.getNombre();
					datosFilas[1] = Integer.toString(auxRepuesto.getCantidad());
					datosFilas[2] = Integer.toString(auxRepuesto.getPrecio());
					datosFilas[3] = Integer.toString(auxRepuesto.getId());
					
					modelo.addRow(datosFilas);
				}
			}
		}
		
		return modelo;
	}

	public void botonVolver() {
		MenuEmpleado.main(null, modulo);
	}
	
}
