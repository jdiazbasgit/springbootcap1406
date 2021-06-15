package curso.cap.springboot.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.instrumentos.Instrumento;
import curso.cap.springboot.musicos.HombreOrquesta;
import curso.cap.springboot.musicos.Solista;

public class PruebaScope {

	public static void main(String[] args) throws InstrumentoRotoException {
		ApplicationContext contexto= new ClassPathXmlApplicationContext("spring.xml");
		Solista solista= (Solista) contexto.getBean("solista");
		HombreOrquesta hombreOrquesta= (HombreOrquesta) contexto.getBean("hombreOrquesta");

		System.out.println(solista.getInstrumento().hashCode());
		System.out.println("------- toca solista -----");
		solista.tocar();
		System.out.println("------- cambia el solista el sonido al tambor ----");
		solista.getInstrumento().setSonido("nuevo sonido de tambor");
		System.out.println("----- toca otra vez el solista ------");
		solista.tocar();
		System.out.println("--------- toca el hombre orquesta --------");
		hombreOrquesta.tocar();
		for (Instrumento instrumento : hombreOrquesta.getInstrumentos()) {
			System.out.println(instrumento.hashCode());
		}
		
	}

}
