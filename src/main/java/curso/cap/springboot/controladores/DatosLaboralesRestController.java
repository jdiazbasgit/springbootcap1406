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
import curso.cap.springboot.repositorios.DatoLaboralCRUDRepository;
import lombok.Data;



@RestController
@Data
@RequestMapping("/api")
public class DatosLaboralesRestController {
	
	@Autowired
	private DatoLaboralCRUDRepository repository;
	
	@GetMapping("/datosLaborales")
	public Resources<DatoLaboral> datosLaborales(){
		
		Iterable<DatoLaboral> datosLaborales=getRepository().findAll();
		for (DatoLaboral datoLaboral : datosLaborales) {
			datoLaboral.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(CargoRestControler.class).getCargoById(datoLaboral.getCargo().getId())).withRel("cargo"));
			datoLaboral.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DatosLaboralesRestController.
					class).getDatoLaboralFreomID(datoLaboral.getIdDatoLaboral())).withSelfRel());
		}
		
		
		return new Resources<DatoLaboral>(datosLaborales);
		
	}
	
	@GetMapping("/datosLaborales/{id}")
	public Resource<DatoLaboral> getDatoLaboralFreomID(@PathVariable int id)
	{
		if(getRepository().existsById(id))
		{
			DatoLaboral datoLaboral= getRepository().findById(id).get();
			datoLaboral.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(CargoRestControler.class).getCargoById(datoLaboral.getCargo().getId())).withRel("cargo"));
			datoLaboral.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DatosLaboralesRestController.
					class).getDatoLaboralFreomID(datoLaboral.getIdDatoLaboral())).withSelfRel());
			
			return new Resource<DatoLaboral>(datoLaboral);
		}
		return null;
	}
		
		

}
