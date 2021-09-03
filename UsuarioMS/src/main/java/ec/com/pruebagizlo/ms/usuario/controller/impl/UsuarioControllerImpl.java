package ec.com.pruebagizlo.ms.usuario.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;
import ec.com.pruebagizlo.ms.usuario.constants.UsuarioConstants;
import ec.com.pruebagizlo.ms.usuario.controller.contract.IUsuarioController;
import ec.com.pruebagizlo.ms.usuario.controller.type.ResponseType;
import ec.com.pruebagizlo.ms.usuario.service.contract.IUsuarioSvc;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-12T15:06:36.856291900-05:00[America/Bogota]")
@RestController
public class UsuarioControllerImpl implements IUsuarioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioControllerImpl.class);

	@Autowired
	IUsuarioSvc usuarioSvc;

	public ResponseEntity<?> consultaTipoUsuario(TipoUsuarioEnum tipo) {

		LOGGER.info("Inicia consultar usuario por tipo");
		ResponseEntity<?> rpsConsultarTipo = null;

		try {
			List<Object> usuarioType = usuarioSvc.consultaTipoUsuario(tipo);
			rpsConsultarTipo = ResponseEntity.ok(usuarioType);

		} catch (Exception e) {
			LOGGER.error("Exception Error al consultar usuario por tipo: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.info("Fin consultar usuario por tipo");
		return rpsConsultarTipo;

	}

	@Override
	public ResponseEntity<?> crearUsuarioExterno(@Valid UsuarioExternoType body) {

		LOGGER.info("Inicia crear usuario");
		ResponseEntity<?> rpsCrearUsuario = null;

		try {
			UsuarioExternoType usuarioType = usuarioSvc.crearUsuarioExterno(body);
			if(usuarioType!=null) {
				return new ResponseEntity<>(new ResponseType().codeResponse("200").description(UsuarioConstants.OK),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			LOGGER.error("Exception Error al crear usuario: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		LOGGER.info("Fin crear usuario");
		return rpsCrearUsuario;
	}

	@Override
	public ResponseEntity<?> crearUsuarioInterno(@Valid UsuarioInternoType body) {

		LOGGER.info("Inicia crear usuario");
		ResponseEntity<?> rpsCrearUsuario = null;

		try {
			UsuarioInternoType usuarioType = usuarioSvc.crearUsuarioInterno(body);
			if(usuarioType!=null) {
				return new ResponseEntity<>(new ResponseType().codeResponse("200").description(UsuarioConstants.OK),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			LOGGER.error("Exception Error al crear usuario: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		LOGGER.info("Fin crear usuario");
		return rpsCrearUsuario;
	}

}
