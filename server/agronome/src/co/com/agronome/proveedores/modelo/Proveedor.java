package co.com.agronome.proveedores.modelo;

import co.com.agronome.proveedores.servlet.Util;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Clase CRUD de Proveedor
 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
 * @project agronome
 * @class Proveedor
 * @date 15/11/2013
 *
 */
public class Proveedor {


	/**
	 * Clase para crear y actualizar un proveedor
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @param usuario TODO
	 * @param pass TODO
	 * @param nombre
	 * @param etiquetas
	 * @param latitud TODO
	 * @param longitud TODO
	 * @param rate
	 */
	public static void createOrUpdateProveedor(String usuario,  String pass, String nit, String nombre, String etiquetas, String telefono, String latitud, String longitud){
		Entity proveedor = getSingleProveedor(usuario);
		if (proveedor == null) {
			proveedor = new Entity("Proveedor", usuario);
			proveedor.setProperty("usuario", usuario);
			proveedor.setProperty("pass", pass);
			proveedor.setProperty("nit", nit);
			proveedor.setProperty("nombre", nombre);
			proveedor.setProperty("telefono", telefono);
			proveedor.setProperty("etiquetas", etiquetas);
			proveedor.setProperty("latitud", latitud);
			proveedor.setProperty("longitud", longitud);
		} else {
			if (nombre != null && !"".equals(nombre)) {
				proveedor.setProperty("nombre", nombre);
			}
			if (telefono != null && !"".equals(telefono)) {
				proveedor.setProperty("telefono", telefono);
			}
			if (etiquetas != null && !"".equals(nombre)) {
				proveedor.setProperty("etiquetas", etiquetas);
			}
		}
		Util.persistEntity(proveedor);
	}
	
	/**
	 * Crear un Proveedor
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @param usuario
	 * @param pass
	 * @param nit
	 * @param nombre
	 * @param etiquetas
	 * @param telefono
	 * @throws Exception 
	 */
	public static void createProveedor(String usuario,  String pass, String nit, String nombre, String etiquetas, String telefono) throws Exception{
		Entity proveedor = getSingleProveedor(usuario);
		if (proveedor == null) {
			proveedor = new Entity("Proveedor", usuario);
			proveedor.setProperty("usuario", usuario);
			proveedor.setProperty("pass", pass);
			proveedor.setProperty("nit", nit);
			proveedor.setProperty("nombre", nombre);
			proveedor.setProperty("telefono", telefono);
			proveedor.setProperty("etiquetas", etiquetas);
		}else{
			throw new Exception("El usuario ya existe");
		}
	}
	

	/**
	 * Consultar todos los proveedores 
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @return
	 */
	public static Iterable<Entity> getAllProveedores() {
		Iterable<Entity> entities = Util.listEntities("Proveedor", null, null);
		return entities;
	}

	/**
	 * Consultar proveedores por nit
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @param proveedorName
	 * @return
	 */
	public static Iterable<Entity> getProveedor(String nit) {
		Iterable<Entity> entities = Util.listEntities("Proveedor", "nit",	nit);
		return entities;
	}
	/**
	 * Obtener un Proveedor
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @param nit
	 * @return
	 */
	public static Entity getSingleProveedor(String usuario) {
		Key key = KeyFactory.createKey("Proveedor", usuario);
		return Util.findEntity(key);
	}
	/**
	 * Validar un Prooveedor
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @return
	 */
	
	public static Entity validateProveedor(String usuario, String pass){
		Key key = KeyFactory.createKey("Proveedor", usuario);
		Entity entity = Util.findEntity(key);
		
		if (entity == null) {
			return null;
		}
		
		String entityPass = (String) entity.getProperty("pass");
		if (entityPass.equalsIgnoreCase(pass)) {
			return entity;
		}else
			return null;
	}
}
