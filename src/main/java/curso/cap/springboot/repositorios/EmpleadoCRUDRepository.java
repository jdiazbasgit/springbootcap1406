package curso.cap.springboot.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.Empleado;


public interface EmpleadoCRUDRepository extends CrudRepository<Empleado, Integer> {
	
	

	@Query("from Empleado e where e.datoPersonal.hijo.chicos>=:chicos")
	public Iterable<Empleado> getEmpleadosByNumeroDeChicos(int chicos);
}
