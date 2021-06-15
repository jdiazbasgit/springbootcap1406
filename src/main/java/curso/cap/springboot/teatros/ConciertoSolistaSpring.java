package curso.cap.springboot.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.cap.springboot.configuracion.Configuracion;
import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.musicos.MusicoInterface;
import curso.cap.springboot.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		//ApplicationContext contexto= new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext contexto= new AnnotationConfigApplicationContext(Configuracion.class);
		MusicoInterface solista= (MusicoInterface) contexto.getBean("solista");
		try {
			solista.tocar();
		} catch (InstrumentoRotoException e) {
		}

	}

}
