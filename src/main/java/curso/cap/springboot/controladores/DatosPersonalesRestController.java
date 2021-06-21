package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.DatoLaboral;
import curso.cap.springboot.entidades.DatoPersonal;
import curso.cap.springboot.repositorios.DatoLaboralCRUDRepository;
import curso.cap.springboot.repositorios.DatoPersonalCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class DatosPersonalesRestController {
	
	@Autowired
	private DatoPersonalCRUDRepository repository;
	
	@GetMapping("/datosPersonales")
	public Iterable<DatoPersonal> datosLaborales(){
		
		return getRepository().findAll();
		
	}
	
	@GetMapping("/datosPersonales/{id}")
	public DatoPersonal getDatoPersonalFreomID(@PathVariable int id)
	{
		if(getRepository().existsById(id))
			return getRepository().findById(id).get();
		return null;
	}
		
		

}
