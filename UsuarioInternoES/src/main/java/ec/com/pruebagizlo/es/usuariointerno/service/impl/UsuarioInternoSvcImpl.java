package ec.com.pruebagizlo.es.usuariointerno.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.pruebagizlo.es.usuariointerno.repository.contract.IUsuarioInternoRepository;
import ec.com.pruebagizlo.es.usuariointerno.repository.model.UsuarioInterno;
import ec.com.pruebagizlo.es.usuariointerno.service.contract.IUsuarioInternoSvc;
import ec.com.pruebagizlo.es.usuariointerno.utils.UsuarioInternoConvert;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

@Service
public class UsuarioInternoSvcImpl implements IUsuarioInternoSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioInternoSvcImpl.class);

	@Autowired
	IUsuarioInternoRepository usuarioInternoRepository;

	@Override
	public List<UsuarioInternoType> consultaTipoUsuario(TipoUsuarioEnum tipo) {
		LOGGER.info("Inicia consulta tipo usuario svc");
		List<UsuarioInterno> usuario = usuarioInternoRepository.consultaTipoUsuario(tipo);
		LOGGER.info("Fin consulta tipo usuario svc");
		return usuario == null ? null : UsuarioInternoConvert.listModelToType(usuario);
	}

	@Override
	public UsuarioInternoType crearUsuarioInterno(@Valid UsuarioInternoType body) {
		LOGGER.info("Inicia crear usuario interno svc");
		body.setId(0);
		UsuarioInterno usuario = usuarioInternoRepository.save(UsuarioInternoConvert.typeToModel(body));
		LOGGER.info("Fin crear usuario interno svc");
		return UsuarioInternoConvert.modelToType(usuario);
	}

}
