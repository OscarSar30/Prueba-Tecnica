package ec.com.pruebagizlo.ms.usuario.service.command.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;
import ec.com.pruebagizlo.ms.usuario.constants.UsuarioConstants;
import ec.com.pruebagizlo.ms.usuario.controller.dto.GenericStringParam;
import ec.com.pruebagizlo.ms.usuario.controller.type.ResponseType;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.ICommand;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.IParam;

@Component
public class ConsultaTipoUsuarioInternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaTipoUsuarioInternoCommand.class);

	@Value("${uri.es-usuarioInterno}")
	private String hostService;

	@Override
	public Object execute(IParam parametro) {
		LOGGER.info("Inicia comando de consultar tipo usuario interno");

		GenericStringParam genericParam = (GenericStringParam) parametro;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UsuarioInternoType>> response = null;

		try {
			response = restTemplate.exchange(hostService.concat(UsuarioConstants.CONSULTA_USUARIO_INTERNO),
					HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioInternoType>>() {
					}, genericParam.getValues().get("tipo"));

		} catch (HttpStatusCodeException e) {
			LOGGER.error("Error en comando de consultar tipo usuario interno: {}\n{}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Fin comando de consultar tipo usuario interno");
		return response.getBody();
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}