package ec.com.pruebagizlo.ms.usuario.constants;

public class UsuarioConstants {

	private UsuarioConstants() {
	}

	/* URI SERVICIOS A ORQUESTAR */
	
	public static final String CREAR_USUARIO_EXTERNO = "/api/es/usuarioExterno";
	public static final String CREAR_USUARIO_INTERNO = "/api/es/usuarioInterno";
	public static final String CONSULTA_USUARIO_EXTERNO = "/api/es/usuario/{tipo}";
	public static final String CONSULTA_USUARIO_INTERNO = "/api/es/usuario/{tipo}";
	public static final String OK = "Su registro se ha creado exitosamente";
	public static final String ERROR_INTERNO = "Estimado usuario, ocurrio un error en el servicio, por favor contactese con el Administrador";


}
