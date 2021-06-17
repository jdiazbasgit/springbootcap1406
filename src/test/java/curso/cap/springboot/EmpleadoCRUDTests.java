package curso.cap.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import curso.cap.springboot.entidades.Empleado;
import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.EmpleadoCRUDRepository;
import lombok.Data;

@SpringBootTest
@Data
class EmpleadoCRUDTests {

	@Autowired
	private EmpleadoCRUDRepository repository;
	
	
	@Test
	@Transactional       
	public void comprobarTodos() {
		
		Iterable<Empleado> empleados= getRepository().findAll();
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getTelefono());
			System.out.println(empleado.getDni());
			System.out.println(empleado.getDatoLaboral().getSalario());
		}
		assertTrue(true);
	}
	
	
}









