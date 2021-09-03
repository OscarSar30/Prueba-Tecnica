package ec.com.pruebagizlo.ms.usuario.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;
import ec.com.pruebagizlo.ms.usuario.controller.dto.GenericStringParam;
import ec.com.pruebagizlo.ms.usuario.controller.dto.UsuarioExternoParam;
import ec.com.pruebagizlo.ms.usuario.controller.dto.UsuarioInternoParam;
import ec.com.pruebagizlo.ms.usuario.service.command.consumer.ConsultaTipoUsuarioExternoCommand;
import ec.com.pruebagizlo.ms.usuario.service.command.consumer.ConsultaTipoUsuarioInternoCommand;
import ec.com.pruebagizlo.ms.usuario.service.command.consumer.CrearUsuarioExternoCommand;
import ec.com.pruebagizlo.ms.usuario.service.command.consumer.CrearUsuarioInternoCommand;
import ec.com.pruebagizlo.ms.usuario.service.contract.IUsuarioSvc;
import ec.com.pruebagizlo.ms.usuario.utils.UsuarioConvert;

@Service
public class UsuarioSvcImpl implements IUsuarioSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioSvcImpl.class);

	@Autowired
	ConsultaTipoUsuarioExternoCommand consultaTipoUsuarioExternoCMD;
	@Autowired
	ConsultaTipoUsuarioInternoCommand consultaTipoUsuarioInternoCMD;
	@Autowired
	CrearUsuarioExternoCommand crearUsuarioExternoCMD;
	@Autowired
	CrearUsuarioInternoCommand crearUsuarioInternoCMD;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> consultaTipoUsuario(TipoUsuarioEnum tipo) {

		GenericStringParam genericStringParams;
		LOGGER.info("Inicia consulta tipo usuario svc");
		/* Verifico que tipo de usuario a consultar */
		if (tipo.equals(TipoUsuarioEnum.EXTERNO)) {
			genericStringParams = new GenericStringParam().addValue("tipo", tipo.toString());
			return (List<Object>) consultaTipoUsuarioExternoCMD.execute(genericStringParams);
		} else if (tipo.equals(TipoUsuarioEnum.INTERNO)) {
			genericStringParams = new GenericStringParam().addValue("tipo", tipo.toString());
			return (List<Object>) consultaTipoUsuarioInternoCMD.execute(genericStringParams);
		}
		LOGGER.info("Fin consulta tipo usuario svc");
		return null;
	}

	@Override
	public UsuarioExternoType crearUsuarioExterno(@Valid UsuarioExternoType body) {
		LOGGER.info("Inicia crear usuario externo svc");
		/* Verifico que tipo de usuario a consultar */
		UsuarioExternoParam usuarioExternoParam = UsuarioConvert.modelToType(body);
		crearUsuarioExternoCMD.execute(usuarioExternoParam);
		LOGGER.info("Fin crear usuario externo svc");
		return body;
	}

	@Override
	public UsuarioInternoType crearUsuarioInterno(@Valid UsuarioInternoType body) {
		LOGGER.info("Inicia crear usuario interno svc");
		/* Verifico que tipo de usuario a consultar */
		UsuarioInternoParam usuarioInternoParam = UsuarioConvert.modelToType(body);
		crearUsuarioInternoCMD.execute(usuarioInternoParam);
		LOGGER.info("Fin crear usuario interno svc");
		return body;
	}

}
