package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.HijoCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class HijoRestController {

	@Autowired
	private HijoCRUDRepository repository;

	@GetMapping("/hijos")
	public Iterable<Hijo> hijos() {
		return getRepository().findAll();
	}

	@GetMapping("/hijos/{id}")
	public Hijo getHijoByID(@PathVariable int id) {
		if (getRepository().existsById(id))
			return getRepository().findById(id).get();
		return null;
	}

}
