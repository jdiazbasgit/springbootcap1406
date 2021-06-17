package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.entidades.Empleado;
import curso.cap.springboot.repositorios.EmpleadoCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class EmpleadoRestControler {

	@Autowired
	private EmpleadoCRUDRepository repository;

	@GetMapping("/empleados")
	public Iterable<Empleado> cargos() {
		return getRepository().findAll();

	}

	@GetMapping("/empleados/{id}")
	public Empleado getCargoById(@PathVariable int id) {
		if (getRepository().findById(id).isPresent())
			return getRepository().findById(id).get();
		return null;
	}

	

}
