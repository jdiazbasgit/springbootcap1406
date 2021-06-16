package curso.cap.springboot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.HijoCRUDRepository;
import lombok.Data;

@SpringBootTest
@Data
class HijoCRUDTests {

	@Autowired
	private HijoCRUDRepository repository;
	
	
	@Test
	public void comprobarTodos() {
		
		Iterable<Hijo> hijos=getRepository().findAll();
		for (Hijo hijo : hijos) {
			System.out.println(hijo.getChicos()+" - "+hijo.getChicas());
		}
		assertNotNull(hijos);
	}
	
	@Test
	public void borraHijo() {
		//getRepository().deleteById(6);
		assertFalse(getRepository().existsById(6));
	}
	
	@Test
	public void testMio() {
		
		List<Hijo> hijos= getRepository().getHijosByChicos(2);
		for (Hijo hijo : hijos) {
			System.out.println(hijo.getChicos()+" - "+hijo.getChicas());
		}
		assertNotNull(hijos);
	}
	
	@Test
	public void test() {
		
		Hijo hijo= new Hijo();
		hijo.setChicos(100);
		hijo.setChicas(200);
		getRepository().save(hijo);
		
		Hijo hijo1= new Hijo();
		hijo1.setChicos(2000);
		hijo1.setChicas(300);
		hijo1.setId(1);
		getRepository().save(hijo1);
		
		Hijo hijo2= new Hijo();
		hijo2.setChicos(1200);
		hijo2.setChicas(1300);
		hijo2.setId(100);
		
		getRepository().save(hijo2);
		
		assertFalse(false);
		
	}

}









