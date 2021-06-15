package curso.cap.springboot.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import curso.cap.springboot.anotaciones.Vigilado;
import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.instrumentos.Instrumento;
import curso.cap.springboot.instrumentos.InstrumentoInteface;
import lombok.Data;

@Component
@Data
public class HombreOrquesta extends Musico{

	@Autowired
	@Qualifier("tocameAMI")
	private List<Instrumento> instrumentos;
	
	@Override
	@Vigilado
	public void tocar() throws InstrumentoRotoException {
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
		
	}

	

}
