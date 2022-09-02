import java.util.Hashtable;
import java.io.IOException;
import java.util.ArrayList;

public class ServicioTecnico {

	public static void main(String[] args) throws IOException {
		Hashtable< Integer, Persona> clientes = new Hashtable< Integer, Persona>();
		Hashtable< Integer, Persona> empleados = new Hashtable< Integer, Persona>();
		ArrayList<Integer> rutsEmpleados = new ArrayList<Integer>();
		
		Menu menu = new Menu(clientes, empleados, rutsEmpleados);
		menu.menuPrincipal();
		
	}


}
