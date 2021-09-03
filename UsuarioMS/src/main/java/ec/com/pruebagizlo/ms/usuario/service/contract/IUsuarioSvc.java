package ec.com.pruebagizlo.ms.usuario.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

public interface IUsuarioSvc {

	List<Object> consultaTipoUsuario(TipoUsuarioEnum tipo);

	UsuarioExternoType crearUsuarioExterno(@Valid UsuarioExternoType body);
	
	UsuarioInternoType crearUsuarioInterno(@Valid UsuarioInternoType body);

}
