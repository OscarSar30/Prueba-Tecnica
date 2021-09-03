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

import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.ms.usuario.constants.UsuarioConstants;
import ec.com.pruebagizlo.ms.usuario.controller.dto.GenericStringParam;
import ec.com.pruebagizlo.ms.usuario.controller.type.ResponseType;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.ICommand;
import ec.com.pruebagizlo.ms.usuario.utils.patterns.IParam;

@Component
public class ConsultaTipoUsuarioExternoCommand implements ICommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaTipoUsuarioExternoCommand.class);

	@Value("${uri.es-usuarioExterno}")
	private String hostService;

	@Override
	public Object execute(IParam parametro) {
		LOGGER.info("Inicia comando de consultar tipo usuario externo");

		GenericStringParam genericParam = (GenericStringParam) parametro;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UsuarioExternoType>> response = null;

		try {
			response = restTemplate.exchange(hostService.concat(UsuarioConstants.CONSULTA_USUARIO_EXTERNO),
					HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioExternoType>>() {
					}, genericParam.getValues().get("tipo"));

		} catch (HttpStatusCodeException e) {
			LOGGER.error("Error en comando de consultar tipo usuario externo: {}\n{}", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(new ResponseType().codeResponse("500").description(UsuarioConstants.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Fin comando de consultar tipo usuario externo");
		return response.getBody();
	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

}