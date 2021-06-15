package curso.cap.springboot.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.instrumentos.Instrumento;
import curso.cap.springboot.musicos.HombreOrquesta;
import curso.cap.springboot.musicos.Musico;
import curso.cap.springboot.musicos.Solista;

@Component
@Aspect
public class MecanicoDeInstrumentos {
	
	@Pointcut("execution(@curso.cap.springboot.anotaciones.Vigilado * *.*(..))")
	public void sujetador() {

	}
	
	@Around("sujetador()")
	public Object arreglarInstrumento(ProceedingJoinPoint joinPoint) throws InstrumentoRotoException {
		Object salida=null;
		Musico musico= (Musico) joinPoint.getTarget();
		
		try {
			//before
			System.out.println("SEÑORES VA A EMPEZAR EL CONCIERTO, APAGUEN LOS MOVILES SOY EL MECANICO");

			salida=joinPoint.proceed();

			//AfterReturning
		} catch (Throwable e) {
			//AfterThrowing
			System.out.println("señores se ha roto el instrumento, lo vamos a arreglar, esperen un momento");
			if(musico.getClass().isInstance(new Solista())) {
				Solista solista=(Solista) musico;
				solista.getInstrumento().setSonido("sonido arreglado del "+solista.getInstrumento().getClass().getSimpleName());
				System.out.println("SEÑORES EL INSTRUMENTO SE HA ARREGLADO CONTINUAMOS EL CONCIERTO;");
				solista.tocar();
			}
			else
			{
				HombreOrquesta hombreOrquesta= (HombreOrquesta) musico;
				for (Instrumento instrumento : hombreOrquesta.getInstrumentos()) {
					if(instrumento.getSonido().equals("nada"))
						instrumento.setSonido("sonido arreglado del "+instrumento.getClass().getSimpleName());
				}
				System.out.println("SEÑORES EL INSTRUMENTO SE HA ARREGLADO CONTINUAMOS EL CONCIERTO;");
				hombreOrquesta.tocar();
			}

		}
		finally {
			//After
			System.out.println("SEÑORES EL CONCIERTO HA TERMINADO, YA PUEDEN ENCENDER LOS MOVILES SOY EL MECANICO");

		}
		
		
		return salida;
	}

}
