package ec.com.pruebagizlo.es.usuariointerno.repository.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.pruebagizlo.es.usuariointerno.repository.model.UsuarioInterno;
import ec.com.pruebagizlo.modelocanonico.TipoUsuarioEnum;

@Repository
public interface IUsuarioInternoRepository extends JpaRepository<UsuarioInterno, Integer> {

	@Query(value = "select * from tb_usuario tu inner join tb_usuario_interno tui on tu.id = tui.id where tu.tipo_usuario = :#{#tipo.name()}", nativeQuery = true)
	List<UsuarioInterno> consultaTipoUsuario(@Param("tipo") TipoUsuarioEnum tipo);
	
}
