package ec.com.pruebagizlo.es.usuarioexterno.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;

public interface IUsuarioExternoSvc {

	List<UsuarioExternoType> consultaTipoUsuario(TipoUsuarioEnum tipo);

	UsuarioExternoType crearUsuarioExterno(@Valid UsuarioExternoType body);

}
