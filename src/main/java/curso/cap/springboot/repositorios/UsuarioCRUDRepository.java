package curso.cap.springboot.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.Usuario;

public interface UsuarioCRUDRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.username=:username")
	public Usuario findByUsername(String username);
	
}
