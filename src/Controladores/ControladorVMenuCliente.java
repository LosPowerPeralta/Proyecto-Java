package Controladores;

import Modulos.ModuloPrincipal;
import Main.Persona;
import Ventanas.BusquedaPorCriterio;
import Ventanas.CreadorNuevaOrden;
import Ventanas.MostrarOrdenesClientes;
import Ventanas.EditarDatosClientes;
import Ventanas.MenuPrincipal;

public class ControladorVMenuCliente {
	private ModuloPrincipal modulo;

	public ControladorVMenuCliente(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public void botonCrearOrden() {
		CreadorNuevaOrden.main(null, modulo);
	}

	public void botonMostrarOrdenes() {
		MostrarOrdenesClientes.main(null, modulo);
	}

	public String getNombreCliente() {
		Persona auxPersona = modulo.getClienteActual();
		
		return auxPersona.getNombre();
	}

	public void botonBuscarOrden() {
		BusquedaPorCriterio.main(null, modulo);
	}

	public void botonEditarDatos() {
		EditarDatosClientes.main(null, modulo);
	}
	
	public void botonSalir() {
		MenuPrincipal.main(null, modulo);
	}

}
