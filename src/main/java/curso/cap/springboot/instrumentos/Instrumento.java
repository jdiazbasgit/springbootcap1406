package curso.cap.springboot.instrumentos;

import curso.cap.springboot.excepciones.InstrumentoRotoException;

public class Instrumento implements InstrumentoInteface{

	private String sonido;
	
	public String sonar() throws InstrumentoRotoException {
		if(getSonido().equals("nada"))
			throw new InstrumentoRotoException();
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
