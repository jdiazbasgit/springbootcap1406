package curso.cap.springboot.musicos;

import curso.cap.springboot.instrumentos.Instrumento;

public class Solista extends Musico {

	private Instrumento instrumento;
	
	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());

	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

}
