package curso.cap.springboot.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Trompeta extends Instrumento{
	
	
	
	@Override
	@Value("tuuu, tuuu, tuuu en anotaciones")
	public void setSonido(String sonido) {
		
		super.setSonido(sonido);
	}

}
