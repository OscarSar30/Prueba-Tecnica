package ec.com.pruebagizlo.es.usuarioexterno.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pruebagizlo.es.usuarioexterno.constants.UsuarioExternoConstants;
import ec.com.pruebagizlo.es.usuarioexterno.controller.contract.IUsuarioExternoController;
import ec.com.pruebagizlo.es.usuarioexterno.controller.type.ResponseType;
import ec.com.pruebagizlo.es.usuarioexterno.service.contract.IUsuarioExternoSvc;
import ec.com.pruebagizlo.es.usuarioexterno.utils.UsuarioExternoValidator;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-12T15:06:36.856291900-05:00[America/Bogota]")
@RestController
public class UsuarioExternoControllerImpl implements IUsuarioExternoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioExternoControllerImpl.class);

	@Autowired
	IUsuarioExternoSvc usuarioExternoSvc;

	public ResponseEntity<?> consultaTipoUsuario(TipoUsuarioEnum tipo) {

		LOGGER.info("Inicia consultar usuario por tipo");
		ResponseEntity<?> rpsConsultarTipo = null;

		try {
			List<UsuarioExternoType> usuarioExternoType = usuarioExternoSvc.consultaTipoUsuario(tipo);
			if (usuarioExternoType.isEmpty()) {
				return new ResponseEntity<>(new ResponseType().codeResponse("404").description(UsuarioExternoConstants.NO_ENCONTRADO),
						HttpStatus.NOT_FOUND);
			}
			rpsConsultarTipo = ResponseEntity.ok(usuarioExternoType);

		} catch (Exception e) {
			LOGGER.error("Exception Error al consultar usuario por tipo: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioExternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.info("Fin consultar usuario por tipo");
		return rpsConsultarTipo;

	}

	public ResponseEntity<?> crearUsuarioExterno(@Valid UsuarioExternoType body) {

		LOGGER.info("Inicia crear usuario externo");
		ResponseEntity<?> rpsCrearUsuarioExterno = null;

		try {
			UsuarioExternoType usuarioExternoType = usuarioExternoSvc.crearUsuarioExterno(body);
			rpsCrearUsuarioExterno = UsuarioExternoValidator.validateResultByCreate(usuarioExternoType);

		} catch (Exception e) {
			LOGGER.error("Exception Error al crear usuario externo: {}", e.getMessage());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioExternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		LOGGER.info("Fin crear usuario externo");
		return rpsCrearUsuarioExterno;
	}

}
