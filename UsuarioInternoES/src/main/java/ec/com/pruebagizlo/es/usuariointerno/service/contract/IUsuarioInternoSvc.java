package ec.com.pruebagizlo.es.usuariointerno.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

public interface IUsuarioInternoSvc {

	List<UsuarioInternoType> consultaTipoUsuario(TipoUsuarioEnum tipo);

	UsuarioInternoType crearUsuarioInterno(@Valid UsuarioInternoType body);

}
