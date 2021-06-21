package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public Resources<Empleado> empleados() {
		Iterable<Empleado> empleados=getRepository().findAll();
		for (Empleado empleado : empleados) {
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosLaboralesRestController.class).getDatoLaboralFreomID(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("dato_laboral"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosPersonalesRestController.class).getDatoPersonalFromID(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("dato_personal"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(EmpleadoRestControler.class).getEmpleadoById(empleado.getIdEmpleado())).withSelfRel());
		}
		
		
		return new Resources<Empleado>(empleados);

	}

	@GetMapping("/empleados/{id}")
	public Resource<Empleado> getEmpleadoById(@PathVariable int id) {
		if (getRepository().findById(id).isPresent())
		{
			Empleado empleado= getRepository().findById(id).get();
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosLaboralesRestController.class).getDatoLaboralFreomID(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("dato_laboral"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosPersonalesRestController.class).getDatoPersonalFromID(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("dato_personal"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(EmpleadoRestControler.class).getEmpleadoById(empleado.getIdEmpleado())).withSelfRel());
			return new Resource(empleado);
		}
		return null;
	}
	
	@GetMapping("/empleados/hijos/{chicos}")
	public Resources<Empleado> getEmpleadosByNumeroDeChicos(@PathVariable int chicos) {
		
		Iterable<Empleado> empleados=getRepository().getEmpleadosByNumeroDeChicos(chicos);
		for (Empleado empleado : empleados) {
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosLaboralesRestController.class).getDatoLaboralFreomID(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("dato_laboral"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(DatosPersonalesRestController.class).getDatoPersonalFromID(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("dato_personal"));
			empleado.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
					methodOn(EmpleadoRestControler.class).getEmpleadoById(empleado.getIdEmpleado())).withSelfRel());
		}
		
		return new Resources<Empleado>(empleados);
		
	}

	

}
