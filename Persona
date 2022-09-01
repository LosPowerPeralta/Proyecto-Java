import java.util.ArrayList;

public class Persona {
	private String nombre;
	//private int numero;
	private int rut;
	private ArrayList< OrdenDeTrabajo > ordenesDeTrabajo;
	
	public Persona() {
	}
	
	public Persona(String nombre, int rut ) {
		this.nombre = nombre;
		this.rut = rut;
		ordenesDeTrabajo = new ArrayList< OrdenDeTrabajo >();
	}
	
	public void listarOrdenes() {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		Persona empleadoAuxiliar = new Persona();
		Persona clienteAuxiliar = new Persona();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			empleadoAuxiliar = ordenAuxiliar.getEmpleado();
			clienteAuxiliar = ordenAuxiliar.getCliente();
			
			System.out.println("	\nORDEN DE TRABAJO N°: " + ordenAuxiliar.getId());
			System.out.println("	DATOS DEL EQUIPO: " + ordenAuxiliar.getNombreProducto());
			System.out.println("	DIAGNÓSTICO TÉCNICO: " + ordenAuxiliar.getDiagnostico());
			System.out.println("	\nEMPLEADO: " + empleadoAuxiliar.getNombre());
			System.out.println("	RUT N°: " + empleadoAuxiliar.getRut());
			System.out.println("	\nCLIENTE: " + clienteAuxiliar.getNombre());
			System.out.println("	RUT N°: " + clienteAuxiliar.getRut());
			//System.out.println("	FECHA DE ENTREGA: ");
			System.out.println("	\nTOTAL: $" + ordenAuxiliar.getTotal());
			if(ordenAuxiliar.getCancelada()) {
				System.out.println("	ORDEN CANCELADA");
			}
		}
	}
	
	public void buscarOrdenEmpleado(int idOrden){
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		Persona empleadoAuxiliar = new Persona();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				empleadoAuxiliar = ordenAuxiliar.getEmpleado();
				
				System.out.println("	\nORDEN DE TRABAJO N°: " + ordenAuxiliar.getId());
				System.out.println("	NOMBRE DEL PRODUCTO A REPARAR: " + ordenAuxiliar.getNombreProducto());
				System.out.println("	DIAGNÓSTICO TÉCNICO: " + ordenAuxiliar.getDiagnostico());
				System.out.println("	\nEMPLEADO: " + empleadoAuxiliar.getNombre());
				System.out.println("	RUT N°: " + empleadoAuxiliar.getRut());
				//System.out.println("	COSTO DE REPUESTO: ");
				//System.out.println("	APLAZAMIENTO DE FECHA POR REPUESTOS: ");
				//System.out.println("	FECHA DE ENTREGA: ");
				System.out.println("	TOTAL: $" + ordenAuxiliar.getTotal());
				if(ordenAuxiliar.getCancelada()) {
					System.out.println("	ORDEN CANCELADA");
				}
				return;
			}
			
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id");
	}
	
	public void buscarOrdenCliente(int idOrden){
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		Persona empleadoAuxiliar = new Persona();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				empleadoAuxiliar = ordenAuxiliar.getEmpleado();
				
				System.out.println("	\nORDEN DE TRABAJO N°: " + ordenAuxiliar.getId());
				System.out.println("	NOMBRE DEL PRODUCTO A REPARAR: " + ordenAuxiliar.getNombreProducto());
				System.out.println("	DIAGNÓSTICO TÉCNICO: " + ordenAuxiliar.getDiagnostico());
				System.out.println("	\nEMPLEADO: " + empleadoAuxiliar.getNombre());
				System.out.println("	TOTAL: $" + ordenAuxiliar.getTotal());
				if(ordenAuxiliar.getCancelada()) {
					System.out.println("	ORDEN CANCELADA");
				}
				return;
			}
			
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id");
	}
	
	public void cancelarOrden(int idOrden) {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		Persona empleadoAuxiliar = new Persona();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			if(ordenAuxiliar.getId() == idOrden){
				empleadoAuxiliar = ordenAuxiliar.getEmpleado();
				
				System.out.println("	\nORDEN DE TRABAJO N°: " + ordenAuxiliar.getId());
				System.out.println("	NOMBRE DEL PRODUCTO A REPARAR: " + ordenAuxiliar.getNombreProducto());
				System.out.println("	DIAGNÓSTICO TÉCNICO: " + ordenAuxiliar.getDiagnostico());
				System.out.println("	\nEMPLEADO: " + empleadoAuxiliar.getNombre());
				System.out.println("	RUT N°: " + empleadoAuxiliar.getRut());
				//System.out.println("	COSTO DE REPUESTO: ");
				//System.out.println("	APLAZAMIENTO DE FECHA POR REPUESTOS: ");
				//System.out.println("	FECHA DE ENTREGA: ");
				System.out.println("	TOTAL: $" + ordenAuxiliar.getTotal());
				System.out.println("	ORDEN CANCELADA");
				if(ordenAuxiliar.getCancelada()) {
				}
				else {
					ordenAuxiliar.setCancelada(true);
				}
				return;
			}
			
		}
		
		System.out.println("No se ha encontrado ninguna orden con ese id");
	}
	
	public void actualizarOrdenes() {
		OrdenDeTrabajo ordenAuxiliar = new OrdenDeTrabajo();
		Persona empleadoAuxiliar = new Persona();
		Persona clienteAuxiliar = new Persona();
		
		if(ordenesDeTrabajo.size() == 0) {
			System.out.println("No se registra ninguna orden en nuestra base de datos.");
			System.out.println("Volviendo al menú");
			return;
		}
		
		for(int i = 0; i < ordenesDeTrabajo.size(); i++) {
			ordenAuxiliar = ordenesDeTrabajo.get(i);
			empleadoAuxiliar = ordenAuxiliar.getEmpleado();
			clienteAuxiliar = ordenAuxiliar.getCliente();
			if(ordenAuxiliar.getCancelada()) {
				System.out.println("	\nORDEN DE TRABAJO N°: " + ordenAuxiliar.getId());
				System.out.println("	DATOS DEL EQUIPO: " + ordenAuxiliar.getNombreProducto());
				System.out.println("	DIAGNÓSTICO TÉCNICO: " + ordenAuxiliar.getDiagnostico());
				System.out.println("	\nEMPLEADO: " + empleadoAuxiliar.getNombre());
				System.out.println("	RUT N°: " + empleadoAuxiliar.getRut());
				System.out.println("	\nCLIENTE: " + clienteAuxiliar.getNombre());
				System.out.println("	RUT N°: " + clienteAuxiliar.getRut());
				//System.out.println("	FECHA DE ENTREGA: ");
				System.out.println("	\nTOTAL: $" + ordenAuxiliar.getTotal());
				System.out.println("	LA ORDEN FUE CANCELADA");
				
				ordenesDeTrabajo.remove(i);
			}
		}
	}
	
	public void agregarNuevaOrden(OrdenDeTrabajo nuevaOrden) {
		ordenesDeTrabajo.add(nuevaOrden);
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
	
	/*public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}*/
	
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	
}
