package curso.cap.springboot.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AvisadorDeAudiencia {

	@Pointcut("execution(@curso.cap.springboot.anotaciones.Vigilado * *.*(..))")
	public void sujetador() {

	}

	@Before("sujetador()")
	public void apagarMoviles() {
		System.out.println("SEÑORES VA A EMPEZAR EL CONCIERTO, APAGUEN LOS MOVILES");
	}

	@After("sujetador()")
	public void enenderMoviles() {
		System.out.println("SEÑORES EL CONCIERTO HA TERMINADO, YA PUEDEN ENCENDER LOS MOVILES");
	}

}