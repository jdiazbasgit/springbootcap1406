package curso.cap.springboot.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMI")
public class Guitarra extends Instrumento{
	
	
	
	@Override
	@Value("tlqn taln tlan en anotaciones")
	public void setSonido(String sonido) {
		
		super.setSonido(sonido);
	}

}
