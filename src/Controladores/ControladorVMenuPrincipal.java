package Controladores;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Main.Persona;
import Main.Empleado;
import Main.Inventario;
import Main.OrdenDeTrabajo;
import Main.Repuesto;
import Modulos.ModuloPrincipal;
import Ventanas.InicioSesionUsuario;
import Ventanas.InicioSesionEmpleados;

public class ControladorVMenuPrincipal {
	private ModuloPrincipal modulo;
	
	public ControladorVMenuPrincipal() {
		modulo = new ModuloPrincipal();
	}
	
	public ControladorVMenuPrincipal(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public void botonUsuario() {
		InicioSesionUsuario.main(null, modulo);
	}
	
	/**************** | Función importarData() | ****************/
	/* El proposito de esta función es importar todos los datos *
	 * de los csv en el modulo principal para la ejecución 		*
	 * del programa.											*
	 * No recibe valores.										*
	 * No retorna valores.										*/
	public void importarData() throws IOException{
		BufferedReader csvClientes = new BufferedReader(new FileReader("ArchivosCSV\\Clientes.csv"));
		BufferedReader csvEmpleados = new BufferedReader(new FileReader("ArchivosCSV\\Empleados.csv"));
		BufferedReader csvRepuestos = new BufferedReader(new FileReader("ArchivosCSV\\AlmacenDeRepuestos.csv"));
		BufferedReader csvOrdenes = new BufferedReader(new FileReader("ArchivosCSV\\OrdenesDeTrabajo.csv"));
		Repuesto repuestoAux;
		Persona clienteAux;
		Empleado empleadoAux;
		OrdenDeTrabajo ordenAux;
		String lineaTexto;
		String valoresCsv[];
		modulo = new ModuloPrincipal();
		
		lineaTexto = csvClientes.readLine();
		while((lineaTexto = csvClientes.readLine()) != null) {
			valoresCsv = lineaTexto.split(",");
			clienteAux = new Persona(valoresCsv[0], valoresCsv[1], valoresCsv[2], valoresCsv[3]);
			modulo.agregarClienteName(clienteAux);
			modulo.agregarClienteRut(clienteAux);
			modulo.agregarListCliente(clienteAux);
		}
		csvClientes.close();
		
		lineaTexto = csvEmpleados.readLine();
		while((lineaTexto = csvEmpleados.readLine()) != null) {
			valoresCsv = lineaTexto.split(",");
			empleadoAux = new Empleado(valoresCsv[0], valoresCsv[1], valoresCsv[2], valoresCsv[3], valoresCsv[4], Integer.parseInt(valoresCsv[5]));
			modulo.agregarEmpleadoName(empleadoAux);
			modulo.agregarEmpleadoRut(empleadoAux);
			modulo.agregarListEmpleados(empleadoAux);
		}
		csvEmpleados.close();
		
		lineaTexto = csvRepuestos.readLine();
		while((lineaTexto = csvRepuestos.readLine())!= null) {
			valoresCsv = lineaTexto.split(",");
			repuestoAux = new Repuesto(valoresCsv[0], Integer.parseInt(valoresCsv[1]), Integer.parseInt(valoresCsv[2]), Integer.parseInt(valoresCsv[3]));
			modulo.agregarRepuesto(repuestoAux);
		}
		csvRepuestos.close();
		
		lineaTexto = csvOrdenes.readLine();
		while((lineaTexto = csvOrdenes.readLine()) != null) {
			valoresCsv = lineaTexto.split(",");
			clienteAux = modulo.getClienteRut(valoresCsv[0]);
			empleadoAux = modulo.getEmpleadoRut(valoresCsv[1]);
			ordenAux = new OrdenDeTrabajo(clienteAux, empleadoAux, valoresCsv[2], valoresCsv[3], valoresCsv[4], valoresCsv[5], Integer.parseInt(valoresCsv[6]), Integer.parseInt(valoresCsv[7]));
			clienteAux.agregarOrden(ordenAux);
			empleadoAux.agregarOrden(ordenAux);
			modulo.agregarOrden(ordenAux);
		}
		csvOrdenes.close();
	}

	/************* | Función exportarData() | *************/
	/* El proposito de esta función es exportar todos los *
	 * datos utilizados por el usuario o empleado.        *
	 * No recibe valores.								  *
	 * No retorna valores.								  */
	public void exportarData() throws IOException{
		String sep = ",";
		String lF = "\n";
		FileWriter csvClientes = new FileWriter("ArchivosCSV\\Clientes.csv");
		FileWriter csvEmpleados = new FileWriter("ArchivosCSV\\Empleados.csv");
		FileWriter csvRepuestos = new FileWriter("ArchivosCSV\\AlmacenDeRepuestos.csv");
		FileWriter csvOrdenes = new FileWriter("ArchivosCSV\\OrdenesDeTrabajo.csv");
		Inventario auxInventario = modulo.getInventario();
		Persona auxCliente;
		Repuesto auxRepuesto;
		Empleado auxEmpleado;
		OrdenDeTrabajo auxOrden;
		
		
		csvClientes.append("Nombre,Rut,Dirección,Número\n");
		for(int i = 0; i < modulo.getSizeListClientes(); i++) {
			auxCliente = modulo.getListClientes(i);
			csvClientes.append(auxCliente.getNombre());
			csvClientes.append(sep);
			csvClientes.append(auxCliente.getRut());
			csvClientes.append(sep);
			csvClientes.append(auxCliente.getDireccion());
			csvClientes.append(sep);
			csvClientes.append(auxCliente.getCelular());
			csvClientes.append(lF);
		}
		csvClientes.close();
		
		csvEmpleados.append("Nombre,Rut,direccion,celular,Contraseña,sueldo\n");
		for(int i = 0; i < modulo.getSizeEmpleados(); i++) {
			auxEmpleado = modulo.getEmpleado(i);
			csvEmpleados.append(auxEmpleado.getNombre());
			csvEmpleados.append(sep);
			csvEmpleados.append(auxEmpleado.getRut());
			csvEmpleados.append(sep);
			csvEmpleados.append(auxEmpleado.getDireccion());
			csvEmpleados.append(sep);
			csvEmpleados.append(auxEmpleado.getCelular());
			csvEmpleados.append(sep);
			csvEmpleados.append(auxEmpleado.getPassword());
			csvEmpleados.append(sep);
			csvEmpleados.append(String.valueOf(auxEmpleado.getSueldo()));
			csvEmpleados.append(lF);
		}
		csvEmpleados.close();
		
		csvRepuestos.append("Nombre,Cantidad,Precio,Id\n");
		for(int i = 0; i < auxInventario.getSizeListRepuesto(); i++) {
			auxRepuesto = auxInventario.getListRepuesto(i);
			csvRepuestos.append(auxRepuesto.getNombre());
			csvRepuestos.append(sep);
			csvRepuestos.append(String.valueOf(auxRepuesto.getCantidad()));
			csvRepuestos.append(sep);
			csvRepuestos.append(String.valueOf(auxRepuesto.getPrecio()));
			csvRepuestos.append(sep);
			csvRepuestos.append(String.valueOf(auxRepuesto.getId()));
			csvRepuestos.append(lF);
		}
		csvRepuestos.close();
		
		csvOrdenes.append("RutCliente,RutEmpleado,Dispositivo,Diagnóstico,Descripción,Estado,Total,Id\n");
		for(int i = 0; i < modulo.getSizeListOrden(); i++) {
			auxOrden = modulo.getListOrden(i);
			auxCliente = auxOrden.getUsuario();
			auxEmpleado = auxOrden.getEmpleado();
			csvOrdenes.append(auxCliente.getRut());
			csvOrdenes.append(sep);
			csvOrdenes.append(auxEmpleado.getRut());
			csvOrdenes.append(sep);
			csvOrdenes.append(auxOrden.getDispositivo());
			csvOrdenes.append(sep);
			csvOrdenes.append(auxOrden.getDiagnostico());
			csvOrdenes.append(sep);
			csvOrdenes.append(auxOrden.getDescripcion());
			csvOrdenes.append(sep);
			csvOrdenes.append(auxOrden.getEstado());
			csvOrdenes.append(sep);
			csvOrdenes.append(String.valueOf(auxOrden.getTotal()));
			csvOrdenes.append(sep);
			csvOrdenes.append(String.valueOf(auxOrden.getId()));
			csvOrdenes.append(lF);
		}
		csvOrdenes.close();
	}

	public void botonEmpleado() {
		InicioSesionEmpleados.main(null, modulo);
	}
}
