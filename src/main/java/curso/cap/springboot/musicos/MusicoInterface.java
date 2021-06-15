package curso.cap.springboot.musicos;

import curso.cap.springboot.excepciones.InstrumentoRotoException;

public interface MusicoInterface {

	public void tocar() throws InstrumentoRotoException;
	
}
