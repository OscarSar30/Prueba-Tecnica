package ec.com.pruebagizlo.es.usuariointerno.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import ec.com.pruebagizlo.es.usuariointerno.repository.model.UsuarioInterno;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;

public final class UsuarioInternoConvert {

	private UsuarioInternoConvert() {
	}

	public static UsuarioInternoType modelToType(UsuarioInterno usuario) {
		return new ModelMapper().map(usuario, UsuarioInternoType.class);
	}

	public static UsuarioInterno typeToModel(UsuarioInternoType usuarioType) {
		return new ModelMapper().map(usuarioType, UsuarioInterno.class);
	}

	public static List<UsuarioInternoType> listModelToType(List<UsuarioInterno> usuarios) {
		return usuarios.stream().map(usuario -> (modelToType(usuario)))
				.collect(Collectors.toList());
	}

}
