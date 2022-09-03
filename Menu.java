import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Menu{
	private Hashtable< Integer, Persona> mapaClientes;
	private Hashtable< Integer, Persona> mapaEmpleados;
	private ArrayList<Integer> rutsEmpleados;
	private Persona empleadoActual;
	private Persona clienteActual;
	private int idOrdenes;
	
	public Menu( ) {
		mapaClientes = new Hashtable< Integer, Persona>();;
		mapaEmpleados = new Hashtable< Integer, Persona>();;
		rutsEmpleados = new ArrayList<Integer>();
		idOrdenes = 0;
	}
	
	public void hardcodearDatos() {
		Persona empleado = new Persona( "Jaimito", 21324095);
		mapaEmpleados.put(21324095, empleado);
		rutsEmpleados.add(21324095);
		
		empleado = new Persona( "Manuel", 20111222);
		mapaEmpleados.put(20111222, empleado);
		rutsEmpleados.add(20111222);
		
		empleado = new Persona( "Rodrigo", 21111222);
		mapaEmpleados.put(21111222, empleado);
		rutsEmpleados.add(21111222);
		
		empleado = new Persona( "Martín", 22111222);
		mapaEmpleados.put(22111222, empleado);
		rutsEmpleados.add(22111222);
		
		empleado = new Persona( "Carlos", 23111222);
		mapaEmpleados.put(23111222, empleado);
		rutsEmpleados.add(23111222);
		
		Persona cliente = new Persona( "Joaquín", 21000111);
		mapaClientes.put(21000111, cliente);
		
		cliente = new Persona( "Francisco", 22000111);
		mapaClientes.put(22000111, cliente);
		
		cliente = new Persona( "Enrique", 23000111);
		mapaClientes.put(23000111, cliente);

		cliente = new Persona( "Valentina", 24000111);
		mapaClientes.put(24000111, cliente);
		
		cliente = new Persona( "María", 25000111);
		mapaClientes.put(25000111, cliente);
	}
	
	public void menuPrincipal()throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int opcion;
		
		hardcodearDatos(); //Función solo para avance, no para entrega final
		
		while(true) {
			System.out.println("Menu Principal");
			System.out.println("1.- Perfil Empleado");
			System.out.println("2.- Perfil Cliente");
			System.out.println("3.- Salir");
			opcion = Integer.parseInt(leer.readLine());
		
			switch(opcion) {
			case 1: 
				menuEmpleado();
				break;
			
			case 2:
				menuCliente();
				break;
				
			case 3:
				System.out.println("Saliendo del programa");
				return;
				
			default:
				System.out.println("Ingrese una opción válida\n");
				break;
			}
		}
		
	}
	
// ---------------------------------------------------------------EMPLEADO-----------------------------------------------------------------------------
	public boolean ingreasarCuentaEmpleado()throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int rutEmpleado;
		
		System.out.println("\nIngrese su rut sin dígito verificador: ");
		rutEmpleado = Integer.parseInt(leer.readLine());
		
		empleadoActual = (Persona) mapaEmpleados.get( rutEmpleado );
		if( empleadoActual != null ){
			System.out.println("\nIngreso correctamente");
			System.out.println("Nombre empleado: " + empleadoActual.getNombre() );
			return true;
		}
		else {
			System.out.println("No se ha encontrado el usuario.");
			System.out.println("Volviendo al menú principal.");
			return false;
		}
		
	}
	
	public void menuEmpleado()throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String respuesta;
		int idOrdenActual;
		int opcion;
		
		if( !ingreasarCuentaEmpleado() ) {
			return;
		}
		
		while( true ) {
			
			System.out.println("Menu Empleado");
			System.out.println("1.- Listar ordenes de trabajo.");
			System.out.println("2.- Buscar una orden.");
			System.out.println("3.- Cancelar una orden.");
			System.out.println("4.- Actualizar ordenes.");
			//System.out.println("5.- Completar una orden.");
			System.out.println("5.- Salir.");
			opcion = Integer.parseInt(leer.readLine());
			
			switch(opcion) {
			case 1: 
				empleadoActual.listarOrdenes();
				break;
			
			case 2:
				System.out.println("\nIngrese el id de la orden que busca: ");
				idOrdenActual = Integer.parseInt(leer.readLine());
				empleadoActual.buscarOrdenEmpleado(idOrdenActual);
				break;
			
			case 3:
				System.out.println("\nIngrese el id de la orden que desea cancelar: ");
				idOrdenActual = Integer.parseInt(leer.readLine());
				System.out.println("Cancelar una orden es irreversible");
				System.out.println("¿Desea continuar de igual forma? (Ingrese Si o No)");
				respuesta = leer.readLine();
				if(respuesta.equals("Si")) {
					empleadoActual.cancelarOrden(idOrdenActual);
				}
				
				break;
			
			/*case 4: 
				completarOrden();
				break;
			}*/
			case 4:
				System.out.println("\nActualizar ordenes eliminará, de la lista de ordenes, a aquellas que esten canceladas.");
				empleadoActual.actualizarOrdenes();
				break;
			
			case 5:
				return;
				
			default:
				System.out.println("Ingrese una opción válida\n");
				break;
			}
		}
	}
	
// -----------------------------------------------------------------CLIENTE-----------------------------------------------------------------------------
	public boolean ingreasarCuentaCliente()throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int rutCliente;
		String respuesta, nombreCliente;
		
		System.out.println("\nIngrese su rut sin dígito verificador: ");
		rutCliente = Integer.parseInt(leer.readLine());
		
		clienteActual = (Persona) mapaClientes.get( rutCliente );
		if( clienteActual != null ){
			System.out.println("\nIngreso correctamente");
			System.out.println("Nombre cliente: " + clienteActual.getNombre() );
			return true;
		}
		else {
			System.out.println("No se ha encontrado el usuario.");
			System.out.println("Desea registrarse (Ingrese Si o No)");
			respuesta = leer.readLine();
			if(respuesta.equals("Si")) {
				System.out.println("Ingrese su nombre");
				nombreCliente = leer.readLine();
				clienteActual = new Persona( nombreCliente, rutCliente);
				mapaClientes.put(rutCliente, clienteActual);
				System.out.println("\nIngreso correctamente");
				System.out.println("Nombre cliente: " + clienteActual.getNombre() );
				return true;
			}
			else {
				System.out.println("Volviendo al menú principal.");
				return false;
			}
		}
	}
	
	
	public void menuCliente()throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String respuesta;
		int idOrdenActual;
		int opcion;
		
		if( !ingreasarCuentaCliente() ) {
			return;
		}
		
		while( true ) {
			
			System.out.println("Menu Cliente");
			System.out.println("1.- Agregar nueva orden.");
			System.out.println("2.- Listar mis ordenes.");
			System.out.println("3.- Buscar una orden.");
			System.out.println("4.- Cancelar una orden.");
			System.out.println("5.- Actualizar ordenes.");
			System.out.println("6.- Salir.");
			opcion = Integer.parseInt(leer.readLine());
			
			switch(opcion) {
			case 1: 
				ingresarUnaOrden();
				break;
				
			case 2: 
				clienteActual.listarOrdenes();
				break;
			
			case 3:
				System.out.println("\nIngrese el id de la orden que busca: ");
				idOrdenActual = Integer.parseInt(leer.readLine());
				clienteActual.buscarOrdenCliente(idOrdenActual); //Cambiar
				break;
			
			case 4:
				System.out.println("\nIngrese el id de la orden que desea cancelar: ");
				idOrdenActual = Integer.parseInt(leer.readLine());
				System.out.println("Cancelar una orden es irreversible");
				System.out.println("¿Desea continuar de igual forma? (Ingrese Si o No)");
				respuesta = leer.readLine();
				if(respuesta.equals("Si")) {
					clienteActual.cancelarOrden(idOrdenActual);
				}
				
				break;
				
			case 5:
				System.out.println("\nActualizar ordenes eliminará, de su lista de ordenes, a aquellas que esten canceladas.");
				clienteActual.actualizarOrdenes();
				break;
			
			case 6:
				return;
			
			default:
				System.out.println("Ingrese una opción válida\n");
				break;
				
			}
		}
	}
	
	public void ingresarUnaOrden()throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String nombreProducto;
		String diagnostico;
		int total;
		
		System.out.println("\nIngrese el modelo del computador a reparar:");
		nombreProducto = leer.readLine();
		
		System.out.println("Ingrese la descripción del problema: ");
		diagnostico = leer.readLine();
		
		System.out.println("");
		
		//total = calcularTotal();
		total = (int)(Math.random()*100000); //Por el momento será con un número random
		
		obtenerEmpleado(); //Escoge al empleado con menos ordenes
		
		idOrdenes += 1;
		
		OrdenDeTrabajo nuevaOrden = new OrdenDeTrabajo(nombreProducto, diagnostico, clienteActual, empleadoActual, total, idOrdenes);
		clienteActual.agregarNuevaOrden(nuevaOrden);
		empleadoActual.agregarNuevaOrden(nuevaOrden);
	}
	
	public void obtenerEmpleado(){
		
		int rutActual = rutsEmpleados.get(0);
		Persona empleadoAuxiliar = mapaEmpleados.get( rutActual );
		int menorCantidadOrdenes = empleadoAuxiliar.getCantOrdenes();
		empleadoActual = empleadoAuxiliar;
		
		for(int i = 0; i < rutsEmpleados.size(); i++) {
			rutActual = rutsEmpleados.get(i);
			empleadoAuxiliar = mapaEmpleados.get( rutActual );
			if(empleadoAuxiliar.getCantOrdenes() < menorCantidadOrdenes) {
				menorCantidadOrdenes = empleadoAuxiliar.getCantOrdenes();
				empleadoActual = empleadoAuxiliar;
			}
		}
		
		//OTRA OPCIÓN PARA ESCOGER EMPLEADOS
		//int rutRandom = rutsEmpleados.get(0);
		//empleadoActual = (Persona) mapaEmpleados.get( rutRandom );
	}
}
