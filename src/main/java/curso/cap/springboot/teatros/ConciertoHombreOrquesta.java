package curso.cap.springboot.teatros;

import java.util.ArrayList;

import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.instrumentos.Instrumento;
import curso.cap.springboot.musicos.HombreOrquesta;

public class ConciertoHombreOrquesta {

	public static void main(String[] args) throws InstrumentoRotoException {
		Instrumento tambor= new Instrumento();
		Instrumento trompeta= new  Instrumento();
		Instrumento guitarra= new Instrumento();
		tambor.setSonido("pom, pom, pom");
		trompeta.setSonido("tuuu, tuuu,tuuu");
		guitarra.setSonido("tlan, tlan, tlan");
		HombreOrquesta hombreOrquesta= new HombreOrquesta();
		hombreOrquesta.setInstrumentos(new ArrayList<Instrumento>());
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.tocar();
		

	}

}
