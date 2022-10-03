package Main;

public class OrdenDeTrabajo {
	private String dispositivo;
	private String descripcion;
	private String diagnostico;
	private String estado;
	private Persona usuario;
	private Empleado empleado;
	private int total;
	private int id;
	
	public OrdenDeTrabajo(Persona usuario, Empleado empleado, String dispositivo, String diagnostico, String descripcion, String estado,int total, int id) {
		this.dispositivo = dispositivo;
		this.descripcion = descripcion;
		this.diagnostico = diagnostico;
		this.usuario = usuario;
		this.empleado = empleado;
		this.total = total;
		this.id = id;
		this.estado = estado;
	}
	
	public OrdenDeTrabajo(Persona usuario, Empleado empleado, String dispositivo, String descripcion, String estado, int id) {
		this.usuario = usuario;
		this.empleado = empleado;
		this.dispositivo = dispositivo;
		this.descripcion = descripcion;
		this.id = id;
		this.estado = estado;
		diagnostico = "En espera de revisión";
		total = 0; 
	}
	
	public OrdenDeTrabajo(Persona usuario, Empleado empleado, String dispositivo, String descripcion, int id) {
		this.usuario = usuario;
		this.empleado = empleado;
		this.dispositivo = dispositivo;
		this.descripcion = descripcion;
		this.id = id;
		estado = "Activo";
		diagnostico = "En espera de revisión";
		total = 0; 
	}
	
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public void setUsuario(Persona usuario) {
		this.usuario = usuario;
	}
	
	public void setTrabajador(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public Persona getUsuario() {
		return usuario;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public String getDispositivo() {
		return dispositivo;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
 	
	public int getTotal() {
		return total;
	}
	
	public int getId() {
		return id;
	}
}
