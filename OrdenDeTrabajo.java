public class OrdenDeTrabajo {
	private String nombreProducto;
	private String diagnostico;
	private Persona cliente;
	private Persona empleado;
	private int total;
	private int id;
	private boolean ordenCancelada; 
	//private String fechaEntrega; DD/MM/AAAA
	//private diasAplazamiento;
	//private ArrayList< Repuestos > repuestosUtilizados;
	
	public OrdenDeTrabajo(){
		
	}
	
	public OrdenDeTrabajo(String nombreProducto, String diagnostico, Persona cliente, Persona empleado, int total, int id){
		this.nombreProducto = nombreProducto;
		this.diagnostico = diagnostico;
		this.cliente = cliente;
		this.empleado = empleado;
		this.total = total;
		this.id = id;
		ordenCancelada  = false;
	}
	
	public void mostrarOrdenParaEmpleado() {
		System.out.println("\nORDEN DE TRABAJO N°: " + id);
		System.out.println("	NOMBRE DEL PRODUCTO A REPARAR: " + nombreProducto);
		System.out.println("	DIAGNÓSTICO TÉCNICO: " + diagnostico);
		System.out.println("\nEMPLEADO: " + empleado.getNombre());
		System.out.println("	RUT N°: " + empleado.getRut());
		//System.out.println("	COSTO DE REPUESTO: ");
		//System.out.println("	APLAZAMIENTO DE FECHA POR REPUESTOS: ");
		//System.out.println("	FECHA DE ENTREGA: ");
		System.out.println("\nTOTAL: $" + total);
		if(ordenCancelada) {
			System.out.println("----ORDEN CANCELADA----");
		}
		System.out.println("--------------------------------------------------------");
	}
	
	public void mostrarOrdenParaCliente() {
		System.out.println("\nORDEN DE TRABAJO N°: " + id);
		System.out.println("	DATOS DEL EQUIPO: " + nombreProducto);
		System.out.println("	DIAGNÓSTICO TÉCNICO: " + diagnostico);
		System.out.println("\nEMPLEADO: " + empleado.getNombre());
		System.out.println("	RUT N°: " + empleado.getRut());
		System.out.println("\nCLIENTE: " + cliente.getNombre());
		System.out.println("	RUT N°: " + cliente.getRut());
		//System.out.println("	FECHA DE ENTREGA: ");
		System.out.println("\nTOTAL: $" + total);
		if(ordenCancelada) {
			System.out.println("----ORDEN CANCELADA----");
		}
		System.out.println("--------------------------------------------------------");
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public Persona getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Persona empleado) {
		this.empleado = empleado;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getCancelada() {
		return ordenCancelada;
	}
	public void setCancelada(boolean ordenCancelada) {
		this.ordenCancelada = ordenCancelada;
	}
}
