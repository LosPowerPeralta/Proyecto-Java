package Main;

public class Persona {
	private String nombre;
	private String rut;
	private String direccion;
	private String celular;
	private CarpetaDeOrdenes carpeta;
	
	public Persona(String nombre, String rut) {
		this.nombre = nombre;
		this.rut = rut;
		direccion = new String();
		celular = new String();
		carpeta = new CarpetaDeOrdenes();
	}
	
	public Persona(String nombre, String rut, String direccion) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		celular = new String();
		carpeta = new CarpetaDeOrdenes();
	}
	
	public Persona(String nombre, String rut, String direccion, String celular) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.celular = celular;
		carpeta = new CarpetaDeOrdenes();
	}
	
	public void agregarOrden(OrdenDeTrabajo newOrden) {
		carpeta.agregarOrden(newOrden);
	}
	
	public void cambiarEstado(int id) {
		OrdenDeTrabajo auxOrden = carpeta.getOrden(id);
		
		auxOrden.setEstado("Cancelado");
	}
	
	public void cambiarEstado(String dispositivo) {
		OrdenDeTrabajo auxOrden = carpeta.getOrden(dispositivo);
		
		auxOrden.setEstado("Cancelado");
	}
	
	public void eliminarOrden(int id) {
		carpeta.eliminarOrden(id);
	}
	
	public void eliminarOrden(String dispositivo) {
		carpeta.eliminarOrden(dispositivo);
	}
	
	public OrdenDeTrabajo getOrden(int id) {
		return carpeta.getOrden(id);
	}
	
	public OrdenDeTrabajo getOrden(String dispositivo) {
		return carpeta.getOrden(dispositivo);
	}
	
	public OrdenDeTrabajo getListOrden(int i) {
		return carpeta.getListOrden(i);
	}
	
	public int getSizeListOrden() {
		return carpeta.getSizeListOrdenes();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getRut() {
		return rut;
	}

	public String getDireccion() {
		return direccion;
	}
	public String getCelular() {
		return celular;
	}
}
