package curso.cap.springboot.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.cap.springboot.musicos.MusicoInterface;

public class ConciertoHombreOrquestaSpring {

	public static void main(String[] args) {
		ApplicationContext contexto= new ClassPathXmlApplicationContext("spring.xml");
		MusicoInterface hombreOrquesta= (MusicoInterface) contexto.getBean("hombreOrquesta");
		hombreOrquesta.tocar();

	}

}
