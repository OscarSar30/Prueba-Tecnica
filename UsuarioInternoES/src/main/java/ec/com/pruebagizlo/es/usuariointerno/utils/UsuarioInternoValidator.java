package ec.com.pruebagizlo.es.usuariointerno.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.com.pruebagizlo.es.usuariointerno.contants.UsuarioInternoConstants;
import ec.com.pruebagizlo.es.usuariointerno.controller.type.ResponseType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

public final class UsuarioInternoValidator {

	private UsuarioInternoValidator() {

	}

	public static ResponseEntity<ResponseType> validateResultByCreate(UsuarioInternoType result) {
		if (result == null) {
			return new ResponseEntity<>(
					new ResponseType().codeResponse("500").description(UsuarioInternoConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(new ResponseType().codeResponse("201").description(UsuarioInternoConstants.CREACION_COMPLETADA),
				HttpStatus.CREATED);
	}

}
