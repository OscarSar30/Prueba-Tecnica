package ec.com.pruebagizlo.ms.usuario.controller.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;
import ec.com.pruebagizlo.modelocanonico.UsuarioExternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioInternoType;
import ec.com.pruebagizlo.modelocanonico.UsuarioType;
import ec.com.pruebagizlo.ms.usuario.controller.type.ResponseType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
public interface IUsuarioController {
    

    @Operation(summary = "Consulta Usuario por Tipo de Usuario", description = "Consulta Usuario por Tipo de Usuario", tags={ "UsuarioMS v1.0" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UsuarioType.class)))),
        
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ResponseType.class))) })
    @RequestMapping(value = "/api/ms/usuario/{tipo}",
        produces = "application/json; charset=UTF-8",
        method = RequestMethod.GET)
    ResponseEntity<?> consultaTipoUsuario(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("tipo") TipoUsuarioEnum tipo);


    @Operation(summary = "Crear nuevo usuario", description = "Crear nuevo usuario", tags={ "UsuarioMS v1.0" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ResponseType.class))) })
    @RequestMapping(value = "/api/ms/usuarioExterno",
        produces = "application/json; charset=UTF-8", 
        consumes = "application/json; charset=UTF-8",
        method = RequestMethod.POST)
    ResponseEntity<?> crearUsuarioExterno(@Parameter(in = ParameterIn.DEFAULT, description = "Crear nuevo usuario", schema=@Schema()) @Valid @RequestBody UsuarioExternoType body);


    @Operation(summary = "Crear nuevo usuario", description = "Crear nuevo usuario", tags={ "UsuarioMS v1.0" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ResponseType.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ResponseType.class))) })
    @RequestMapping(value = "/api/ms/usuarioInterno",
        produces = "application/json; charset=UTF-8", 
        consumes = "application/json; charset=UTF-8",
        method = RequestMethod.POST)
    ResponseEntity<?> crearUsuarioInterno(@Parameter(in = ParameterIn.DEFAULT, description = "Crear nuevo usuario", schema=@Schema()) @Valid @RequestBody UsuarioInternoType body);

}

