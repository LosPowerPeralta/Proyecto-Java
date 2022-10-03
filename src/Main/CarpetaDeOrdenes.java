package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class CarpetaDeOrdenes {
	private HashMap<Integer, OrdenDeTrabajo> ordenesId;
	private HashMap<String, OrdenDeTrabajo> ordenesDispositivo;
	private ArrayList<OrdenDeTrabajo> listOrdenes;
	
	public CarpetaDeOrdenes() {
		ordenesId = new HashMap<Integer, OrdenDeTrabajo>();
		ordenesDispositivo = new HashMap<String, OrdenDeTrabajo>();
		listOrdenes = new ArrayList<OrdenDeTrabajo>();
	}
	
	/********************* | Funcion agregarOrden() | *************************/
	/* El proposito de esta función es agregar una orden a partir de un       *
	 * objeto orden.          												  *	
	 * Recibe un objeto OrdenDeTrabajo.                                       *
	 * Retorna true si la orden fue agregada con éxito y false en caso        *
	 * contrario.                                                             */
	public boolean agregarOrden(OrdenDeTrabajo newOrden) {
		if(!ordenesId.containsKey(newOrden.getId())) {
			ordenesId.put(newOrden.getId(), newOrden);
			ordenesDispositivo.put(newOrden.getDispositivo(), newOrden);
			if(!ordenesId.containsKey(newOrden.getId())) return false;
			if(!ordenesDispositivo.containsKey(newOrden.getDispositivo())) return false;
			if(!listOrdenes.add(newOrden)) return false;
		}
		
		return true;
	}
	
	/********************* | Función agregarOrden() | *************************/
	/* El proposito de esta función es agregar una orden a partir de datos    *
	 * que necesita un objeto Orden, genera la orden y por último la agrega.  *          												
	 * Recibe un objeto usuario, empleado, las cadenas dispositivo y          *
	 * descripcion y un valor int el cual almacena un id.                     *
	 * Retorna true si la orden fue agregada con éxito y false en caso        *
	 * contrario.                                                             */
	public boolean agregarOrden(Persona usuario, Empleado empleado, String dispositivo, String descripcion, int id) {
		OrdenDeTrabajo auxOrden = new OrdenDeTrabajo(usuario, empleado, dispositivo, descripcion, id);
		
		if(!ordenesId.containsKey(id)) {
			ordenesId.put(id, auxOrden);
			ordenesDispositivo.put(dispositivo, auxOrden);
			if(!ordenesId.containsKey(id)) return false;
			if(!ordenesDispositivo.containsKey(dispositivo)) return false;
			if(!listOrdenes.add(auxOrden)) return false;
		}
		
		return true;
	}
	
	/**************** | Función eliminarOrden() | ********************/
	/* El proposito de esta función es eliminar una orden a partir   *
	 * de una id.													 *
	 * Recibe un valor entero id.									 *
	 * Retorna true si la orden fue eliminada con éxito y false      *
	 * en caso contrario. 											 */
	public boolean eliminarOrden(int id) {
		OrdenDeTrabajo aux = ordenesId.get(id);
		
		ordenesId.remove(id);
		ordenesDispositivo.remove(aux.getDispositivo());
		if(ordenesId.containsKey(aux.getId())) return false;
		if(ordenesDispositivo.containsKey(aux.getDispositivo())) return false;
		listOrdenes.remove(aux);
		
		return true;
	}
	
	/**************** | Función eliminarOrden() | ********************/
	/* El proposito de esta función es eliminar una orden a partir   *
	 * de un dispositivo.											 *
	 * Recibe un String que representa un dispositivo.				 *
	 * Retorna true si la orden fue eliminada con éxito y false      *
	 * en caso contrario. 											 */
	public boolean eliminarOrden(String dispositivo) {
		OrdenDeTrabajo aux = ordenesDispositivo.get(dispositivo);
		
		ordenesId.remove(aux.getId());
		ordenesDispositivo.remove(dispositivo);
		if(ordenesId.containsKey(aux.getId())) return false;
		if(ordenesDispositivo.containsKey(aux.getDispositivo())) return false;
		listOrdenes.remove(aux);
		
		return true;
	}
	
	public OrdenDeTrabajo getOrden(int id) {
		return ordenesId.get(id);
	}
	
	public OrdenDeTrabajo getOrden(String dispositivo) {
		return ordenesDispositivo.get(dispositivo);
	}
	
	public OrdenDeTrabajo getListOrden(int i) {
		return listOrdenes.get(i);
	}
	
	public int getSizeListOrdenes() {
		return listOrdenes.size();
	}
}
