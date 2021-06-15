package curso.cap.springboot.musicos;

import curso.cap.springboot.excepciones.InstrumentoRotoException;

public abstract class Musico implements MusicoInterface {

	public abstract void tocar() throws InstrumentoRotoException;

}
