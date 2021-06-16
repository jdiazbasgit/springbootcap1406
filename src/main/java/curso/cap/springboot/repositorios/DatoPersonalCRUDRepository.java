package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.DatoPersonal;

public interface DatoPersonalCRUDRepository extends CrudRepository<DatoPersonal, Integer> {

}
