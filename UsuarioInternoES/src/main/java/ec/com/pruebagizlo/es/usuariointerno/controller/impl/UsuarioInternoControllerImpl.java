package ec.com.pruebagizlo.es.usuariointerno.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pruebagizlo.es.usuariointerno.contants.UsuarioInternoConstants;
import ec.com.pruebagizlo.es.usuariointerno.controller.contract.IUsuarioInternoController;
import ec.com.pruebagizlo.es.usuariointerno.controller.type.ResponseType;
import ec.com.pruebagizlo.es.usuariointerno.service.contract.IUsuarioInternoSvc;
import ec.com.pruebagizlo.es.usuariointerno.utils.UsuarioInternoValidator;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-12T15:06:36.856291900-05:00[America/Bogota]")
@RestController
public class UsuarioInternoControllerImpl implements IUsuarioInternoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioInternoControllerImpl.class);

	@Autowired
	IUsuarioInternoSvc usuarioInternoSvc;

	public ResponseEntity<?> consultaTipoUsuario(TipoUsuarioEnum tipo) {

		LOGGER.info("Inicia consultar usuario por tipo");
		ResponseEntity<?> rpsConsultarTipo = null;

		try {
			List<UsuarioInternoType> usuarioInternoType = usuarioInternoSvc.consultaTipoUsuario(tipo);
			if (usuarioInternoType.isEmpty()) {
				return new ResponseEntity<>(new ResponseType().codeResponse("404").description(UsuarioInternoConstants.NO_ENCONTRADO),
						HttpStatus.NOT_FOUND);
			}
			rpsConsultarTipo = ResponseEntity.ok(usuarioInternoType);

		} catch (Exception e) {
			LOGGER.error("Exception Error al consultar usuario por tipo: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioInternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.info("Fin consultar usuario por tipo");
		return rpsConsultarTipo;

	}

	public ResponseEntity<?> crearUsuarioInterno(@Valid UsuarioInternoType body) {

		LOGGER.info("Inicia crear usuario interno");
		ResponseEntity<?> rpsCrearUsuarioInterno = null;

		try {
			UsuarioInternoType usuarioInternoType = usuarioInternoSvc.crearUsuarioInterno(body);
			rpsCrearUsuarioInterno = UsuarioInternoValidator.validateResultByCreate(usuarioInternoType);

		} catch (Exception e) {
			LOGGER.error("Exception Error al crear usuario interno: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioInternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		LOGGER.info("Fin crear usuario interno");
		return rpsCrearUsuarioInterno;
	}

}
