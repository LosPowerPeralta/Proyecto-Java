package Modulos;

import Main.CarpetaDeOrdenes;

import Main.Empleado;
import Main.Inventario;
import Main.OrdenDeTrabajo;
import Main.Persona;
import Main.Repuesto;
import Main.CollectionPersona;

public class ModuloPrincipal {
	private CollectionPersona personas;
	private CarpetaDeOrdenes carpeta;
	private Inventario almacen;
	private Persona clienteActual;
	private Empleado empleadoActual;
	
	public void eliminarOrden(int id) {
		carpeta.eliminarOrden(id);
	}

	public void agregarClienteName(Persona newCliente) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarClienteName(newCliente);
	}
	
	public void agregarClienteRut(Persona newCliente) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarClienteRut(newCliente);
	}
	
	public void agregarListCliente(Persona newCliente) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarListCliente(newCliente);
	}
	
	public void agregarEmpleadoName(Empleado newEmpleado) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarEmpleadoName(newEmpleado);
	}
	
	public void agregarEmpleadoRut(Empleado newEmpleado) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarEmpleadoRut(newEmpleado);
	}
	
	public void agregarListEmpleados(Empleado newEmpleado) {
		if(personas == null) {
			personas = new CollectionPersona();
		}
		personas.agregarListEmpleados(newEmpleado);
	}
	
	public void agregarOrden(OrdenDeTrabajo newOrden) {
		if(carpeta == null) {
			carpeta = new CarpetaDeOrdenes();
		}
		
		carpeta.agregarOrden(newOrden);
	}
	
	public void agregarRepuesto(Repuesto newRepuesto) {
		if(almacen == null) {
			almacen = new Inventario();
		}
		
		almacen.agregarRepuesto(newRepuesto);
	}
	
	public void setInventario(Inventario almacen) {
		this.almacen = almacen;
	}
	
	public void setClienteActual(Persona clienteActual) {
		this.clienteActual = clienteActual;
	}
	
	public void setEmpleadoActual(Empleado empleadoActual) {
		this.empleadoActual = empleadoActual;
	}
	
	public Persona getClienteActual() {
		return clienteActual;
	}
	
	public OrdenDeTrabajo getListOrden(int i) {
		return carpeta.getListOrden(i);
	}
	
	public Empleado getEmpleadoName(String name) {
		if(personas == null) return null;
		if(personas.getEmpleadoName(name) != null) {
			return personas.getEmpleadoName(name);
		}
		
		return null;
	}
	
	public Empleado getEmpleadoActual() {
		return empleadoActual;
	}
	
	public Empleado getEmpleadoRut(String Rut) {
		if(personas == null) return null;
		if(personas.getEmpleadoRut(Rut) != null) {
			return personas.getEmpleadoRut(Rut);
		}
		return null;
	}
	
	public Empleado getEmpleado(int i) {
		return personas.getEmpleado(i);
	}
	
	public int getSizeEmpleados() {
		return personas.getSizeEmpleados();
	}
	
	
	public int getSizeListOrden() {
		return carpeta.getSizeListOrdenes();
	}
	
	public OrdenDeTrabajo getOrden(int id) {
		return carpeta.getOrden(id);
	}
	
	public Inventario getInventario() {
		return almacen;
	}

	public Persona getClienteRut(String rut) {
		return personas.getClienteRut(rut);
	}

	public int getSizeListClientes() {
		return personas.getSizeListClientes();
	}
	
	public Persona getListClientes(int i) {
		return personas.getListClientes(i);
	}
}
