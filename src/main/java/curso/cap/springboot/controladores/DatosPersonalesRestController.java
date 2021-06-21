package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.DatoLaboral;
import curso.cap.springboot.entidades.DatoPersonal;
import curso.cap.springboot.repositorios.DatoLaboralCRUDRepository;
import curso.cap.springboot.repositorios.DatoPersonalCRUDRepository;
import curso.cap.springboot.repositorios.HijoCRUDRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class DatosPersonalesRestController {
	
	@Autowired
	private DatoPersonalCRUDRepository repository;
	
	@GetMapping("/datosPersonales")
	public Resources<DatoPersonal> datosPersonales(){
		
		Iterable<DatoPersonal> datosPersonales=getRepository().findAll();
		for (DatoPersonal datoPersonal : datosPersonales) {
			
			datoPersonal.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(HijoRestController.class).getHijoByID(datoPersonal.getHijo().getId())).withRel("hijo"));
			datoPersonal.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosPersonalesRestController.class).getDatoPersonalFromID(datoPersonal.getIdDatoPersonal())).withSelfRel());
			
		}
		return new Resources(datosPersonales);
		
	}
	
	@GetMapping("/datosPersonales/{id}")
	public Resource<DatoPersonal> getDatoPersonalFromID(@PathVariable int id)
	{
		if(getRepository().existsById(id)) {
			DatoPersonal datoPersonal=getRepository().findById(id).get();
			datoPersonal.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(HijoRestController.class).getHijoByID(datoPersonal.getHijo().getId())).withRel("hijo"));
			datoPersonal.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosPersonalesRestController.class).getDatoPersonalFromID(datoPersonal.getIdDatoPersonal())).withSelfRel());
			return new Resource<DatoPersonal>(datoPersonal);
		}
		return null;
	}
		
		

}
