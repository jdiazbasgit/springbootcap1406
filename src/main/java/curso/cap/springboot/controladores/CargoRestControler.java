package curso.cap.springboot.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.Cargo;
import curso.cap.springboot.repositorios.CargoCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class CargoRestControler {

	@Autowired
	private CargoCRUDRepository repository;

	@GetMapping("/cargos")
	public Iterable<Cargo> cargos() {
		return getRepository().findAll();

	}

	@GetMapping("/cargos/{id}")
	public Cargo getCargoById(@PathVariable int id) {
		if (getRepository().findById(id).isPresent())
			return getRepository().findById(id).get();
		return null;
	}

	@PostMapping("/cargos")
	public Cargo grabaCargo(@RequestBody Cargo cargo) {

		return getRepository().save(cargo);

	}

	@DeleteMapping("/cargos/{id}")
	public boolean borraCargo(@PathVariable int id) {
		try {
			if (getRepository().existsById(id)) {
				getRepository().deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
