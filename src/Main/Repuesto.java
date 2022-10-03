package Main;

public class Repuesto {
	private String nombre;
	private int id;
	private int cantidad;
	private int precio;
	
	public Repuesto(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
		cantidad = 0;
		precio = 0;
	}
	
	public Repuesto(String nombre, int id, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		id = 0;
		precio = 0;
	}
	
	public Repuesto(String nombre, int id, int cantidad, int precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public int getPrecio() {
		return precio;
	}
}
