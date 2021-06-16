package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.Cargo;

public interface CargoCRUDRepository extends CrudRepository<Cargo, Integer> {

}
