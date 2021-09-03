package ec.com.pruebagizlo.es.usuarioexterno.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import ec.com.pruebagizlo.es.usuarioexterno.repository.model.UsuarioExterno;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;

public final class UsuarioExternoConvert {

	private UsuarioExternoConvert() {
	}

	public static UsuarioExternoType modelToType(UsuarioExterno usuario) {
		return new ModelMapper().map(usuario, UsuarioExternoType.class);
	}

	public static UsuarioExterno typeToModel(UsuarioExternoType usuarioType) {
		return new ModelMapper().map(usuarioType, UsuarioExterno.class);
	}

	public static List<UsuarioExternoType> listModelToType(List<UsuarioExterno> usuarios) {
		return usuarios.stream().map(usuario -> (modelToType(usuario)))
				.collect(Collectors.toList());
	}

}
