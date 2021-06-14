package curso.cap.springboot.musicos;

import java.util.List;

import curso.cap.springboot.instrumentos.Instrumento;

public class HombreOrquesta extends Musico{

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
