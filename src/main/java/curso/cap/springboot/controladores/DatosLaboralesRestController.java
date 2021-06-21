package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.DatoLaboral;
import curso.cap.springboot.repositorios.DatoLaboralCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class DatosLaboralesRestController {
	
	@Autowired
	private DatoLaboralCRUDRepository repository;
	
	@GetMapping("/datosLaborales")
	public Iterable<DatoLaboral> datosLaborales(){
		
		return getRepository().findAll();
		
	}
	
	@GetMapping("/datosLaborales({id}")
	public DatoLaboral getDatoLaboralFreomID(@PathVariable int id)
	{
		if(getRepository().existsById(id))
			return getRepository().findById(id).get();
		return null;
	}
		
		

}
