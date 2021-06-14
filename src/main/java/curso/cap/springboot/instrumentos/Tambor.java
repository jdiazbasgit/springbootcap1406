package curso.cap.springboot.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("tocameAMI")
//@Scope("prototype")
public class Tambor extends Instrumento{
	
	
	
	@Override
	//@Value("pom pom pom en anotaciones")
	public void setSonido(String sonido) {
		
		super.setSonido(sonido);
	}

}
