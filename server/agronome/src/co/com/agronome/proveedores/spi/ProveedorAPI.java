package co.com.agronome.proveedores.spi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import co.com.agronome.proveedores.spi.model.ProveedorDTO;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/**
 * Consulta de Proveedores por API
 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
 * @project agronome
 * @class ProveedorAPI
 * @date 15/11/2013
 *
 */
@Api(
	    name = "agronome",
	    version = "v1",
	    clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	    audiences = {Ids.ANDROID_AUDIENCE}
	)
public class ProveedorAPI {
	
	
	/**
	 * Consulta de Tag 
	 * @author <a href="mailto:rachirib@gmail.com">Ricardo Alberto Chiriboga</a>
	 * @date 15/11/2013
	 * @param tagName
	 * @return
	 */
	@ApiMethod(name = "proveedor.consultarproveedortag", httpMethod = "POST")
	public List<ProveedorDTO> consultarProveedorPorTag(@Named("tagname") String tagName){
		ProveedorDTO dto  = new ProveedorDTO();
		dto.setNit("123123");
		dto.setNombre("asdasd");
		dto.setTelefono("123132");
		dto.setLatitud("123");
		dto.setLongitud("123123");
		
		ProveedorDTO dto2  = new ProveedorDTO();
		dto.setNit("asdasd");
		dto.setNombre("123123");
		dto.setTelefono("123132");
		dto.setLatitud("123");
		dto.setLongitud("123123");
		
		List<ProveedorDTO> lista = new ArrayList<ProveedorDTO>();
		lista.add(dto);
		lista.add(dto2);
		
		return lista;
	}

}
