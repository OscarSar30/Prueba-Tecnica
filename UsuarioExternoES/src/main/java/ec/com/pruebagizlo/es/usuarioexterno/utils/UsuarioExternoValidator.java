package ec.com.pruebagizlo.es.usuarioexterno.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.com.pruebagizlo.es.usuarioexterno.constants.UsuarioExternoConstants;
import ec.com.pruebagizlo.es.usuarioexterno.controller.type.ResponseType;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;

public final class UsuarioExternoValidator {

	private UsuarioExternoValidator() {

	}

	public static ResponseEntity<ResponseType> validateResultByCreate(UsuarioExternoType result) {
		if (result == null) {
			return new ResponseEntity<>(
					new ResponseType().codeResponse("500").description(UsuarioExternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(new ResponseType().codeResponse("201").description(UsuarioExternoConstants.CREACION_COMPLETADA),
				HttpStatus.CREATED);
	}

}
