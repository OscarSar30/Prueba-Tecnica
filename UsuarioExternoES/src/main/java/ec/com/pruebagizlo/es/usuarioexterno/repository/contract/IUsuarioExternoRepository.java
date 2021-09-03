package ec.com.pruebagizlo.es.usuarioexterno.repository.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.pruebagizlo.es.usuarioexterno.repository.model.UsuarioExterno;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;

@Repository
public interface IUsuarioExternoRepository extends JpaRepository<UsuarioExterno, Integer> {

	@Query(value = "select * from tb_usuario tu inner join tb_usuario_externo tue on tu.id = tue.id where tu.tipo_usuario = :#{#tipo.name()}", nativeQuery = true)
	List<UsuarioExterno> consultaTipoUsuario(@Param("tipo") TipoUsuarioEnum tipo);
	
}
