package ec.com.pruebagizlo.es.usuarioexterno.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.pruebagizlo.es.usuarioexterno.repository.contract.IUsuarioExternoRepository;
import ec.com.pruebagizlo.es.usuarioexterno.repository.model.UsuarioExterno;
import ec.com.pruebagizlo.es.usuarioexterno.service.contract.IUsuarioExternoSvc;
import ec.com.pruebagizlo.es.usuarioexterno.utils.UsuarioExternoConvert;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;

@Service
public class UsuarioExternoSvcImpl implements IUsuarioExternoSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioExternoSvcImpl.class);

	@Autowired
	IUsuarioExternoRepository usuarioExternoRepository;

	@Override
	public List<UsuarioExternoType> consultaTipoUsuario(TipoUsuarioEnum tipo) {
		LOGGER.info("Inicia consulta tipo usuario svc");
		List<UsuarioExterno> usuario = usuarioExternoRepository.consultaTipoUsuario(tipo);
		LOGGER.info("Fin consulta tipo usuario svc");
		return usuario == null ? null : UsuarioExternoConvert.listModelToType(usuario);
	}

	@Override
	public UsuarioExternoType crearUsuarioExterno(@Valid UsuarioExternoType body) {
		LOGGER.info("Inicia crear usuario externo svc");
		body.setId(0);
		UsuarioExterno usuario = usuarioExternoRepository.save(UsuarioExternoConvert.typeToModel(body));
		LOGGER.info("Fin crear usuario externo svc");
		return UsuarioExternoConvert.modelToType(usuario);
	}

}
