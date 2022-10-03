package Controladores;

import Modulos.ModuloPrincipal;
import Ventanas.MenuEmpleado;

import javax.swing.table.DefaultTableModel;

import Main.Inventario;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Main.Persona;
import Main.Repuesto;

public class ControladorVAsignarRepuestos extends ControladorVMostrarOrdenesEmpleados {
	
	public ControladorVAsignarRepuestos(ModuloPrincipal modulo) {
		super(modulo);
	}
	
	
	/*********************** | Función botonAsignar() | *************************/
	/* El proposito de esta función es asignar una cantidad de repuestos a una  *
	 * orden descontando la cantidad de esta y aumentando el total de la orden. *
	 * Recibe un id, una cantidad de monitores, placas madres, procesadores, 	*
	 * baterias, disco duros, ssd's y ram's.									*
	 * Retorna true si los datos fueron actualizados con éxito o false en caso  *
	 * contrario.																*/
	public boolean botonAsignar(int id, int monitor, int placaMadre, int procesador, int bateria,
								int discoDuro, int ssd, int ram) {
		Empleado empleadoActual = getModulo().getEmpleadoActual();
		Inventario almacen = getModulo().getInventario();
		OrdenDeTrabajo auxOrden;
		Repuesto auxRepuesto;
		
		auxOrden = empleadoActual.getOrden(id);
		
		auxRepuesto = almacen.getRepuesto("Monitor");
		if(auxRepuesto.getCantidad() - monitor < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - monitor);
		auxOrden.setTotal(monitor * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("Placa Madre");
		
		if(auxRepuesto.getCantidad() - placaMadre < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - placaMadre);
		auxOrden.setTotal(auxOrden.getTotal() + placaMadre * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("Procesador");
		if(auxRepuesto.getCantidad() - procesador < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - procesador);
		auxOrden.setTotal(auxOrden.getTotal() + procesador * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("RAM");
		if(auxRepuesto.getCantidad() - ram < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - ram);
		auxOrden.setTotal(auxOrden.getTotal() + ram * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("Batería"); 
		if(auxRepuesto.getCantidad() - bateria < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - bateria);
		auxOrden.setTotal(auxOrden.getTotal() + bateria * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("SSD");
		if(auxRepuesto.getCantidad() - ssd < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - ssd);
		auxOrden.setTotal(auxOrden.getTotal() + ssd * auxRepuesto.getPrecio());
		
		auxRepuesto = almacen.getRepuesto("Disco duro portátil");
		if(auxRepuesto.getCantidad() - discoDuro < 0) return false;
		auxRepuesto.setCantidad(auxRepuesto.getCantidad() - discoDuro);
		auxOrden.setTotal(auxOrden.getTotal() + discoDuro * auxRepuesto.getPrecio());
		
		return true;
	}
	
	/**************** | Función agregarDatosModel() | *********************/
	/* El proposito de esta función es es crear un nuevo modelo para la   *
	 * tabla utilizada en la ventana.									  *
	 * No recibe valores.												  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatosModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre Cliente", "Nombre Empleado", "Dispositivo", "Diagnostico", "Descripcion", "Estado", "Total", "ID"};
		String datosFilas[] = new String[8];
		Empleado empleadoActual = getModulo().getEmpleadoActual();
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
	 * id o dispositivo.												  *
	 * Recibe un boolean id y dispositivo, además recibe un filtro.		  *
	 * Retorna un modelo DefaulTableModel.								  */
	public DefaultTableModel agregarDatosModel(boolean id, boolean dispositivo, String busqueda) {
		DefaultTableModel modelo = new DefaultTableModel();
		String columnas[] = {"Nombre Cliente", "Nombre Empleado", "Dispositivo", "Diagnostico", "Descripcion", "Estado", "Total", "ID"};
		String datosFilas[] = new String[8];
		Empleado empleadoActual = getModulo().getEmpleadoActual();
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
		}
		
		return modelo;
	}
	
	public void botonVolver() {
		MenuEmpleado.main(null, getModulo());
	}
	
}
