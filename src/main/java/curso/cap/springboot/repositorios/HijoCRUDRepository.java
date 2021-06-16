package curso.cap.springboot.repositorios;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.Hijo;

public interface HijoCRUDRepository extends CrudRepository<Hijo, Integer> {
	
	
	//@Query(value="select id,chicos,chicas from hijos where chicos>:chicos",nativeQuery = true)
	@Query("from Hijo h where h.chicos>:chicos")
	@Transactional
	public List<Hijo> getHijosByChicos(int chicos);
	
	

}
