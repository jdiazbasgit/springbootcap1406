package curso.cap.springboot.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.cap.springboot.musicos.HombreOrquesta;

public class ConciertoHombreOrquestaSpring {

	public static void main(String[] args) {
		ApplicationContext contexto= new ClassPathXmlApplicationContext("spring.xml");
		HombreOrquesta hombreOrquesta= (HombreOrquesta) contexto.getBean("hombreOrquesta");
		hombreOrquesta.tocar();

	}

}
