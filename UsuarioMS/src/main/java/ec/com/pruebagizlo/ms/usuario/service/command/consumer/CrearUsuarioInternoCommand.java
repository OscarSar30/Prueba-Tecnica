package ec.com.pruebagizlo.ms.usuario.service.command.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ec.com.pruebagizlo.ms.usuario.constants.UsuarioConstants;
import ec.com.pruebagizlo.ms.usuario.controller.dto.UsuarioInternoParam;
import ec.com.pruebagizlo.ms.usuario.controller.type.ResponseType;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.ICommand;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.IParam;

@Component
public class CrearUsuarioInternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrearUsuarioInternoCommand.class);

	@Value("${uri.es-usuarioInterno}")
	private String hostService;

	@Override
	public Object execute(IParam parametro) {

		LOGGER.info("Inicia comando de crear usuario interno");

		UsuarioInternoParam usuario = (UsuarioInternoParam) parametro;

		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseType> response;

		try {

			headers.set("Content-Type", "application/json");
			HttpEntity<UsuarioInternoParam> request = new HttpEntity<>(usuario, headers);

			response = restTemplate.exchange(hostService.concat(UsuarioConstants.CREAR_USUARIO_INTERNO),
					HttpMethod.POST, request, ResponseType.class);
			
		} catch (HttpStatusCodeException e) {
			LOGGER.error("Error en comando de crear usuario interno: {}", e.getMessage(), e.fillInStackTrace());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Fin comando de crear usuario interno");
		return response.getBody();

	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}
