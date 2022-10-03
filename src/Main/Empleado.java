package Main;

public class Empleado extends Persona{
	private String password;
	private int sueldo;
	
	public Empleado(String nombre, String rut, String direccion, String celular, String password, int sueldo) {
		super(nombre, rut, direccion, celular);
		this.password = password;
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, String rut, String direccion, String password, int sueldo) {
		super(nombre, rut, direccion);
		this.password = password;
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, String rut, String direccion, String password) {
		super(nombre, rut, direccion);
		this.password = password;
		this.sueldo = 0;
	}
	
	
	/****************** | Función cambiarEstadoOrden() | ********************/
	/* El proposito de esta función es cambiar el estado de una orden a		*
	 * partir de lo seleccionado por un empleado.							*
	 * Recibe un int id para buscar la orden y un String estado.			*
	 * No retorna valores.													*/ 
	public void cambiarEstadoOrden(int id, String estado) {
		OrdenDeTrabajo auxOrden = getOrden(id);
		
		auxOrden.setEstado(estado);
	}
	
	/****************** | Función cambiarEstadoOrden() | ********************/
	/* El proposito de esta función es cambiar el estado de una orden a		*
	 * partir de lo seleccionado por un empleado.							*
	 * Recibe un String dispositivo para buscar la orden y un String estado.*
	 * No retorna valores.													*/ 
	public void cambiarEstadoOrden(String dispositivo, String estado) {
		OrdenDeTrabajo auxOrden = getOrden(dispositivo);
		
		auxOrden.setEstado(estado);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getSueldo() {
		return sueldo;
	}
}
