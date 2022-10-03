package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionPersona {
	private HashMap<String, Persona> clientesName;
	private HashMap<String, Persona> clientesRut;
	private HashMap<String, Empleado> empleadosName;
	private HashMap<String, Empleado> empleadosRut;
	private ArrayList<Persona> listClientes;
	private ArrayList<Empleado> listEmpleados;
	
	public	CollectionPersona() {
		clientesName = new HashMap<String, Persona>();
		clientesRut = new HashMap<String, Persona>();
		empleadosName = new HashMap<String, Empleado>();
		empleadosRut = new HashMap<String, Empleado>();
		listClientes = new ArrayList<Persona>();
		listEmpleados = new ArrayList<Empleado>();
	}
	
	public void agregarClienteName(Persona newCliente) {
		clientesName.put(newCliente.getNombre(), newCliente);
	}
	
	public void agregarClienteRut(Persona newCliente) {
		clientesRut.put(newCliente.getRut(), newCliente);
	}
	
	public void agregarListCliente(Persona newCliente) {
		listClientes.add(newCliente);
	}
	
	public void agregarEmpleadoName(Empleado newEmpleado) {
		empleadosName.put(newEmpleado.getNombre(), newEmpleado);
	}
	
	public void agregarEmpleadoRut(Empleado newEmpleado) {
		empleadosRut.put(newEmpleado.getRut(), newEmpleado);
	}
	
	public void agregarListEmpleados(Empleado newEmpleado) {
		listEmpleados.add(newEmpleado);
	}
	
	public Empleado getEmpleadoName(String name) {
		if(empleadosName.containsKey(name)) {
			return empleadosName.get(name);
		}
		
		return null;
	}
	
	public Empleado getEmpleadoRut(String Rut) {
		if(empleadosRut.containsKey(Rut)) {
			return empleadosRut.get(Rut);
		}
		return null;
	}
	
	public Empleado getEmpleado(int i) {
		return listEmpleados.get(i);
	}
	
	public int getSizeEmpleados() {
		return listEmpleados.size();
	}
	
	public Persona getClienteName(String nombre) {
		if(clientesName == null) return null;
		if(clientesName.containsKey(nombre)) {
			return clientesName.get(nombre);
		}
		
		return null;
	}
	
	public Persona getClienteRut(String rut) {
		if(clientesRut == null) return null;
		if(clientesRut.containsKey(rut)) {
			return clientesRut.get(rut);
		}
		
		return null;
	}
	
	public Persona getListClientes(int i) {
		return listClientes.get(i);
	}
	
	public int getSizeListClientes() {
		return listClientes.size();
	}
}
