package curso.cap.springboot.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.cap.springboot.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		ApplicationContext contexto= new ClassPathXmlApplicationContext("spring.xml");
		Solista solista= (Solista) contexto.getBean("solista");
		solista.tocar();

	}

}
