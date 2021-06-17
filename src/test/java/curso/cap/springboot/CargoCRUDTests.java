package curso.cap.springboot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.cap.springboot.repositorios.CargoCRUDRepository;
import lombok.Data;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Data
class CargoCRUDTests {

	@Autowired
	private CargoCRUDRepository repository;
	
	
	@Test
	    
	public void comprobarTodos() {
		getRepository().grabarDos();
		
		assertTrue(true);
	}
	
	
}









