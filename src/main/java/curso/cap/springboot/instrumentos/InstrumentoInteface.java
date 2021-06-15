package curso.cap.springboot.instrumentos;

import curso.cap.springboot.excepciones.InstrumentoRotoException;

public interface InstrumentoInteface {
	public String sonar() throws InstrumentoRotoException;

}
