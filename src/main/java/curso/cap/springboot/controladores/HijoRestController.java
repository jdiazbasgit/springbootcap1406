package curso.cap.springboot.controladores;

import java.util.List;

import javax.servlet.annotation.WebInitParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/hijosPaginados/{pagina}/{cantidad}/{order}")
	public Iterable<Hijo> getHijosPaginados(@PathVariable int pagina,@PathVariable int cantidad,@PathVariable String order){
		
		Iterable<Hijo> hijos=getRepository().findAll(PageRequest.of(pagina, cantidad,Sort.by(Order.asc(order))));
		
		return hijos;
	}
	
	@GetMapping("/hijosPaginados")
	public Iterable<Hijo> getHijosPaginadosParametros(@RequestParam int pagina,@RequestParam int cantidad,@RequestParam String order){
		
		Iterable<Hijo> hijos=getRepository().findAll(PageRequest.of(pagina, cantidad,Sort.by(Order.desc(order))));
		
		return hijos;
	}

}
