package Main;

import java.util.HashMap;
import java.util.ArrayList;

public class Inventario {
	private HashMap<String, Repuesto> repuestosName;
	private HashMap<Integer, Repuesto> repuestosId;
	private ArrayList<Repuesto> listRepuesto;
	
	public Inventario() {
		repuestosName = new HashMap<String, Repuesto>();
		repuestosId = new HashMap<Integer, Repuesto>();
		listRepuesto = new ArrayList<Repuesto>();
	}
	
	/*************** | Función agregarRepuesto() | *************/
	/* El proposito de esta función es agregar una nueva orden *
	 * en todas las colecciones que contiene el inventario.	   *
	 * Recibe un objeto Repuesto. 							   *
	 * Retorna true si el repuestro fue agregado con éxito 	   *	
	 * o false en caso contrario.							   */
	public boolean agregarRepuesto(Repuesto newRepuesto) {
		Repuesto repuestoAux;
		
		if(repuestosName.containsKey(newRepuesto.getNombre())) {
			repuestoAux = repuestosName.get(newRepuesto.getNombre());
			repuestoAux.setCantidad(repuestoAux.getCantidad() + newRepuesto.getCantidad());
		}
		else {
			repuestosName.put(newRepuesto.getNombre(), newRepuesto);
			repuestosId.put(newRepuesto.getId(), newRepuesto);
			if(!repuestosName.containsKey(newRepuesto.getNombre())) return false;
			if(!repuestosId.containsKey(newRepuesto.getId())) return false;
			if(!listRepuesto.add(newRepuesto)) return false;
		}
		
		return true;
	}
	
	/*************** | Función agregarRepuesto() | *************/
	/* El proposito de esta función es agregar una nueva orden *
	 * en todas las colecciones que contiene el inventario.	   *
	 * Recibe un nombre, un id, una cantidad y el precio del   *
	 * repuesto.				 							   *
	 * Retorna true si el repuestro fue agregado con éxito 	   *	
	 * o false en caso contrario.							   */
	public boolean agregarRepuesto(String nombre, int id, int cantidad, int precio) {
		Repuesto repuestoAux = new Repuesto(nombre, id, cantidad, precio);
		
		if(repuestosName.containsKey(nombre)) {
			repuestoAux = repuestosName.get(nombre);
			repuestoAux.setCantidad(repuestoAux.getCantidad() + cantidad);
		}
		else {
			repuestosName.put(nombre, repuestoAux);
			repuestosId.put(id, repuestoAux);
			if(!repuestosName.containsKey(nombre)) return false;
			if(!repuestosId.containsKey(id)) return false;
			if(!listRepuesto.add(repuestoAux)) return false;
		}
		
		return true;
	}
	
	/************** | Función eliminarRepuesto() | **************/
	/* El proposito de esta función es eliminar un repuesto de  *
	 * todas las colecciones dentro del inventario.             *
	 * Recibe un id para realizar la busqueda de la orden.		*
	 * Retorna true si el repuesto fue eliminado con éxito o 	*
	 * false en caso contrario.									*/
	public boolean eliminarRepuesto(int id) {
		Repuesto repuestoAux = repuestosId.remove(id);
		if(repuestosId.containsKey(id)) return false;
		repuestosName.remove(repuestoAux.getNombre());
		if(repuestosName.containsKey(repuestoAux.getNombre())) return false;
		listRepuesto.remove(repuestoAux);
		
		return true;
	}
	
	/************** | Función eliminarRepuesto() | **************/
	/* El proposito de esta función es eliminar un repuesto de  *
	 * todas las colecciones dentro del inventario.             *
	 * Recibe un nombre para realizar la busqueda de la orden.	*
	 * Retorna true si el repuesto fue eliminado con éxito o 	*
	 * false en caso contrario.									*/
	public boolean eliminarRepuesto(String nombre) {
		Repuesto repuestoAux = repuestosName.remove(nombre);
		if(repuestosName.containsKey(nombre)) return false;
		repuestosId.remove(repuestoAux.getId());
		if(repuestosId.containsKey(repuestoAux.getId())) return false;
		listRepuesto.remove(repuestoAux);
		
		return true;
	}
	
	/*************** | Función descontarRepuesto() | **************/
	/* El proposito de esta función es desminuir la cantidad que  *
	 * tiene cada repuesto.										  *											
	 * Recibe un nombre y la cantidad que desea disminuir.		  *
	 * Retorna true si la cantidad pudo disminuir con éxito o 	  *
	 * false en caso contrario.									  */
	public boolean descontarRepuesto(String nombre, int cantidad) {
		Repuesto repuestoAux;
		
		if (!repuestosName.containsKey(nombre)) return false;
		
		repuestoAux = repuestosName.get(nombre);
		repuestoAux.setCantidad(repuestoAux.getCantidad() - cantidad);
		
		return true;
	}
	
	/*************** | Función descontarRepuesto() | **************/
	/* El proposito de esta función es desminuir la cantidad que  *
	 * tiene cada repuesto.										  *											
	 * Recibe un id y la cantidad que desea disminuir.		 	  *
	 * Retorna true si la cantidad pudo disminuir con éxito o 	  *
	 * false en caso contrario.									  */
	public boolean descontarRepuesto(int id, int cantidad) {
		Repuesto repuestoAux;
		
		if (!repuestosId.containsKey(id)) return false;
		
		repuestoAux = repuestosId.get(id);
		repuestoAux.setCantidad(repuestoAux.getCantidad() - cantidad);
		
		return true;
	}
	
	public Repuesto getRepuesto(String nombre) {
		if (repuestosName.containsKey(nombre)) {
			return repuestosName.get(nombre);
		}
		
		return null;
	}
	
	public Repuesto getRepuesto(int id) {
		if (repuestosId.containsKey(id)) {
			return repuestosId.get(id);
		}
		
		return null;
	}
	
	public Repuesto getListRepuesto(int i) {
		return listRepuesto.get(i);
	}
	
	public int getSizeListRepuesto() {
		return listRepuesto.size();
	}
}
