import java.util.ArrayList;

public class Persona {
	private String nombre;
	private String numero;
	private int rut;
	private ArrayList< OrdenDeTrabajo > ordenesDeTrabajo;
	
	public Persona() {
	}
	
	public Persona(String nombre, int rut ) {
		this.nombre = nombre;
		this.rut = rut;
		numero = null;
		ordenesDeTrabajo = new ArrayList< OrdenDeTrabajo >();
	}
	
	public Persona(String nombre, String numero, int rut ) {
		this.nombre = nombre;
		this.rut = rut;
		this.numero = numero;
		ordenesDeTrabajo = new ArrayList< OrdenDeTrabajo >();
	}
	
	public void listarOrdenes() {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú\n");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			ordenAuxiliar.mostrarOrdenParaCliente();
			
		}
	}
	
	public void buscarOrdenEmpleado(int idOrden){
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú\n");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				ordenAuxiliar.mostrarOrdenParaEmpleado();
				return;
			}
			
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id\n");
	}
	
	public void buscarOrdenEmpleado(double idOrden){
		buscarOrdenCliente((int) idOrden);
	}
	
	public void buscarOrdenEmpleado(long idOrden){
		buscarOrdenCliente((int) idOrden);
	}
	
	public void buscarOrdenCliente(int idOrden){
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú\n");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				ordenAuxiliar.mostrarOrdenParaCliente();
				return;
			}
			
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id\n");
	}
	
	public void buscarOrdenCliente(double idOrden){
		buscarOrdenCliente((int) idOrden);
	}
	
	public void buscarOrdenCliente(long idOrden){
		buscarOrdenCliente((int) idOrden);
	}
	
	public void cancelarOrden(int idOrden) {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú\n");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				if(!ordenAuxiliar.getCancelada()) {
					ordenAuxiliar.setCancelada(true);
				}
				ordenAuxiliar.mostrarOrdenParaCliente();
				return;
			}
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id\n");
	}
	
	public void actualizarOrdenes() {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú\n");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			
			if(ordenAuxiliar.getCancelada()) {
				ordenAuxiliar.mostrarOrdenParaCliente();
				ordenesDeTrabajo.remove(i);
			}
		}
	}
	
	public void agregarNuevaOrden(OrdenDeTrabajo nuevaOrden, Persona empleado) {
		ordenesDeTrabajo.add(nuevaOrden);
		empleado.ordenesDeTrabajo.add(nuevaOrden);
		
	}
	
	public void agregarNuevaOrden(OrdenDeTrabajo nuevaOrden) {
		ordenesDeTrabajo.add(nuevaOrden);
	}
	
	public void agregarNuevaOrden(String nombreProducto, String diagnostico, Persona cliente, Persona empleado, int total, int id) {
		OrdenDeTrabajo nuevaOrden = new OrdenDeTrabajo(nombreProducto, diagnostico, cliente, empleado, total, id);
		ordenesDeTrabajo.add(nuevaOrden);
		if(this == cliente) {
			empleado.ordenesDeTrabajo.add(nuevaOrden);
		}
		else {
			cliente.ordenesDeTrabajo.add(nuevaOrden);
		}
		
	}
	
	public void agregarNuevaOrden(String nombreProducto, String diagnostico, Persona empleado, int total, int id) {
		OrdenDeTrabajo nuevaOrden = new OrdenDeTrabajo(nombreProducto, diagnostico, this, empleado, total, id);
		ordenesDeTrabajo.add(nuevaOrden);
		empleado.ordenesDeTrabajo.add(nuevaOrden);
		
	}
	
	public int getCantOrdenes() {
		return ordenesDeTrabajo.size();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setNumero(int numero) {
		this.numero = String.valueOf(numero);
	}
	
	public int getRut() {
		return rut;
	}
	
	public void setRut(int rut) {
		this.rut = rut;
	}
	
	public void setRut(String rut) {
		this.rut = Integer.parseInt(rut);
	}
	
}
