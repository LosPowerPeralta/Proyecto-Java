package Controladores;

import Main.Empleado;
import Ventanas.MenuPrincipal;
import Ventanas.MostrarOrdenesEmpleado;
import Ventanas.MostrarRepuestos;
import Ventanas.EditarDatosEmpleado;
import Ventanas.AsignarRepuestos;
import Modulos.ModuloPrincipal;


public class ControladorVMenuEmpleado {
	private ModuloPrincipal modulo;

	public ControladorVMenuEmpleado(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public String getNombreEmpleado() {
		Empleado auxEmpleado = modulo.getEmpleadoActual();
		
		return auxEmpleado.getNombre();
	}

	public void botonVolver() {
		
		MenuPrincipal.main(null, modulo);
	}

	public void botonMostarOrdenes() {
		MostrarOrdenesEmpleado.main(null, modulo);
	}

	public void botonMostrarRepuestos() {
		MostrarRepuestos.main(null, modulo);
		
	}

	public void botonEditarDatos() {
		EditarDatosEmpleado.main(null, modulo);
	}

	public void botonAsignarRepuestos() {
		AsignarRepuestos.main(null, modulo);
	}
	
}
