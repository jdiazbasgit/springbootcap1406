package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import curso.cap.springboot.entidades.Cargo;

public interface CargoCRUDRepository extends CrudRepository<Cargo, Integer> {

	 
	@Transactional
	default void grabarDos() {
		
		Cargo cargo= new Cargo();
		cargo.setDescripcion("nuevo cargo");
		this.save(cargo);
		
		Cargo cargo2= new Cargo();
		cargo2.setDescripcion("aaaaaaaaaaaaaaaa");
		this.save(cargo2);
		
	}
}
