package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.DatoLaboral;

public interface DatoLaboralCRUDRepository extends CrudRepository<DatoLaboral, Integer> {

}
