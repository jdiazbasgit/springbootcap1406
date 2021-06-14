package curso.cap.springboot.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import curso.cap.springboot.instrumentos.Instrumento;

@Component
public class HombreOrquesta extends Musico{

	@Autowired
	@Qualifier("tocameAMI")
	private List<Instrumento> instrumentos;
	
	@Override
	public void tocar() {
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
		
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

}
