package ec.com.pruebagizlo.ms.usuario.utils;

import org.modelmapper.ModelMapper;

import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;
import ec.com.pruebagizlo.ms.usuario.controller.dto.UsuarioExternoParam;
import ec.com.pruebagizlo.ms.usuario.controller.dto.UsuarioInternoParam;

public class UsuarioConvert {

	UsuarioConvert() {
		super();

	}

	public static final UsuarioExternoParam modelToType(UsuarioExternoType usuarioExternoType) {
		return new ModelMapper().map(usuarioExternoType, UsuarioExternoParam.class);
	}
	
	public static final UsuarioInternoParam modelToType(UsuarioInternoType usuarioInternoType) {
		return new ModelMapper().map(usuarioInternoType, UsuarioInternoParam.class);
	}
	
}
